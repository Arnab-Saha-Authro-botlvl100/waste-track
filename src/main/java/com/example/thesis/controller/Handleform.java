package com.example.thesis.controller;

import com.example.thesis.Services.BinService;
import com.example.thesis.Services.ComplainService;
import com.example.thesis.Services.UserService;
import com.example.thesis.model.Bin;
import com.example.thesis.model.Complain;
import com.example.thesis.model.Message;
import com.example.thesis.model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class Handleform {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    @Autowired
    private BinService binService;

    @Autowired
    private ComplainService complainService;

    @RequestMapping(path = "/signupuser", method= RequestMethod.POST)
    public String signupform(@ModelAttribute User user, Model model){
        System.out.println(user.name+" "+user.getRole());
        if(user.getRole().equals("User")){
            user.setRole("ROLE_USER");
        } else if (user.getRole().equals("Worker")) {
            user.setRole("ROLE_WORKER");
        }
        model.addAttribute("user", user);
        user.setPass(passwordEncoder.encode(user.getPass()));
        this.userService.save(user);
        return "index";
    }

    @RequestMapping(path = "/binrequest", method = RequestMethod.POST)
    public String binrequest(@ModelAttribute Bin bin, Model model, HttpSession session){
        this.binService.save(bin);
        Message m = new Message("Succecfully Requested", "success");
        session.setAttribute("message", new Message("Succecfully Requested For Bin", "success"));
        return "redirect:user/index";
    }

    @RequestMapping(path = "/complain", method = RequestMethod.POST)
    public String complain(@ModelAttribute Complain complain, Model model, HttpSession session){
        if(complain.getROLE().equals("ROLE_USER")){
            this.complainService.save(complain);
            Message m = new Message("Succecfully Requested For Complaining", "success");
            session.setAttribute("message", new Message(m.content, m.type));
            return "redirect:user/index";
        } else if (complain.getROLE().equals("ROLE_WORKER")) {
            this.complainService.save(complain);
            Message m = new Message("Succecfully Requested For Complaining", "success");
            session.setAttribute("message", new Message(m.content, m.type));
            return "redirect:worker/index";
        }
        return "index";
    }
    @RequestMapping(path = "/replyform", method = RequestMethod.POST)
    public String reply(@ModelAttribute Complain complain, Model model, @RequestParam("ID") int id, @RequestParam("complainreply") String reply){
//        Optional<Complain> complain1 = complainService.findById(id);
        System.out.println(complain.getROLE()+" "+complain.getDate());
        complain.setReply(reply);
        System.out.println(complain.getROLE()+" "+complain.getDate());
        System.out.println(id);
        System.out.println(reply);
        this.complainService.save(complain);
        return "redirect:admin/index";
    }
}
