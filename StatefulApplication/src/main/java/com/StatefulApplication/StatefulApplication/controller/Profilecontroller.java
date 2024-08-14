package com.StatefulApplication.StatefulApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profilecontroller {

    @GetMapping("/home")
    public String profile ()
    {
        return "Home";
    }
}
