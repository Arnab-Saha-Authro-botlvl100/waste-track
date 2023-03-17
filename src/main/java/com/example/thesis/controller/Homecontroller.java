package com.example.thesis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Homecontroller {

    @GetMapping("/")
    public String homecontroller(){
        System.out.println("home");
        try {
            return "index";
        }catch (Exception e){
            System.err.println(e);
        }
        return "";
    }
}
