package com.example.EcommerceApp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String loginFormView(){
        return "loginform";
    }
    @RequestMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
}
