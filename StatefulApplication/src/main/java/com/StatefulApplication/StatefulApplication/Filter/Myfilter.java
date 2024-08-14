package com.StatefulApplication.StatefulApplication.Filter;
import com.StatefulApplication.StatefulApplication.model.RegistrationUser;
import com.StatefulApplication.StatefulApplication.repository.ProjectRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class Myfilter implements Filter {
    @Autowired
    ProjectRepo repo ;
    @Autowired
    RegistrationUser users ;
    String ugmail = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        boolean sessionid = false;
        String sessiontoken = null;
        String requiredtoken = null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    sessiontoken = cookie.getValue();
                    requiredtoken = repo.findByuserUuid(sessiontoken);
                    if (requiredtoken == null && request.getRequestURI().equals("/logout")) {
                        response.sendRedirect(request.getContextPath() + "/login");
                        return;
                    }
                    if (requiredtoken != null){
                        if (requiredtoken.equals(sessiontoken)) {
                            sessionid = true;
                        }
                }
                }
            }
            if (sessionid == true && request.getRequestURI().equals("/login") || request.getrequestURI().equals("/")||request.getRequestURI().equals("/veryfication"))
            {
                response.sendRedirect(request.getContextPath()+"/home");
                return;
            }
            if (sessionid == false && request.getRequestURI().equals("/home")){
                response.sendRedirect(request.getContextPath()+"/login");
                return;
            }if (sessionid == true && request.getRequestURI().equals("/logout"))
            {
                response.sendRedirect(request.getContextPath()+"/login");
                repo.updateuuid(sessiontoken);
            }
        }

             filterChain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
