package com.StatefulApplication.StatefulApplication.service;
import com.StatefulApplication.StatefulApplication.model.UserLogin;
import com.StatefulApplication.StatefulApplication.repository.ProjectRepo;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    ProjectRepo repo;
     public String verifyuser(UserLogin user)
     {
         String ruser  = repo.findByUserGmail(user.getGmail());
         String users = repo.findByUserpassword(user.getPassword1());
         if (user.getGmail().equals(ruser)&&user.getPassword1().equals(users))
         {
             return "home";
         }else if (ruser==null)
         {
             return "login1";
         }else if (users==null)
         {
             return "wrong";
         }else
         {
             return "user";
         }

     }

     public void addcookie (HttpServletResponse response,UserLogin login)
     {
         String sessionToken  = UUID.randomUUID().toString();
         repo.updateUuid(sessionToken,login.getGmail());
         Cookie cookie = new Cookie("token", sessionToken);
         cookie.setAttribute("usergmail",login.getGmail());
         cookie.setPath("/");
         cookie.setDomain("localhost");
         cookie.setMaxAge(60*60);
         cookie.setHttpOnly(true);
         response.addCookie(cookie);
         System.out.println( cookie.getAttribute("usergmail"));

     }

}
