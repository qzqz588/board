package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class thymleafController {
    @GetMapping("/login")
    public String showLogin(){
        return"login";
    }
    @GetMapping("/main")
    public String showMain(){
        return"main";
    }
    @GetMapping("/join")
    public String showJoin(){
        return"members/new";
    }

}
