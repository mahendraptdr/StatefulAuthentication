package com.StatefulApplication.StatefulApplication.controller;

import com.StatefulApplication.StatefulApplication.model.RegistrationUser;
import com.StatefulApplication.StatefulApplication.model.UserLogin;
import com.StatefulApplication.StatefulApplication.service.LoginService;
import com.StatefulApplication.StatefulApplication.service.Registrationservice;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class UserHandleController{
    @Autowired
    LoginService service;
    @Autowired
    Registrationservice rservice;
    @PostMapping("/veryfication")
    public void verifyuser(UserLogin login, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String hello = service.verifyuser(login);
        if (hello.equals("home")){
            service.addcookie(response, login);
            response.sendRedirect(request.getContextPath()+"/home");
            response.getWriter().write("success");
    }else if (hello.equals("login1"))
        {
            response.sendRedirect(request.getContextPath()+"/login");
             response.getWriter().write("invalidusername");
        }else if (hello.equals("wrong"))
        {
            response.sendRedirect(request.getContextPath()+"/login");
           response.getWriter().write("incorrectpassword");
        }else {
            response.sendRedirect(request.getContextPath()+"/login");
          response.getWriter().write("usernotfound");
        }

    }
    @PostMapping("/useregister")
    public String userregister (RegistrationUser user)
    {

        rservice.register(user);
        return "Login";
    }

}
