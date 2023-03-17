package com.example.thesis.controller;

import com.example.thesis.Services.UserService;
import com.example.thesis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    private UserService userService;

    @GetMapping("index")
    public String loginpage(Principal principal, Model model){
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("userinfo", user);
        return "user/userwelcome";
    }
}
