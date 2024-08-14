package com.StatefulApplication.StatefulApplication.controller;
import com.StatefulApplication.StatefulApplication.model.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Homecontroller {

    UserLogin login;
    @GetMapping("/")
    public String home ()
    {
        System.out.println("hello from");
        return "welcome";
    }
    @GetMapping("/registration")
    public String Signup()
    {
        return "Registration";
    }
    @GetMapping("/login")
    public String Login ()
    {
        return "Login";
    }
    @GetMapping("/logout")
    public String logout ()
    {
        return "Login";
    }

}
