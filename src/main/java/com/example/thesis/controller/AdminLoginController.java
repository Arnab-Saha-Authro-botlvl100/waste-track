package com.example.thesis.controller;

import com.example.thesis.Services.ComplainService;
import com.example.thesis.Services.ReportService;
import com.example.thesis.Services.UserService;
import com.example.thesis.model.Complain;
import com.example.thesis.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private ComplainService complainService;

    @GetMapping("index")
    public String adminlogin(Model model){
        List<Complain> complain = complainService.findAll();
        List<Report> reports = reportService.findAll();

        List<Report> selected = new ArrayList<>();
        List<Complain> usercomplain = new ArrayList<>();
        List<Complain> workercomplain = new ArrayList<>();


        for(int i = 0; i<complain.size(); i++){
//            System.out.println(complain.get(i).ROLE);
            if(complain.get(i).ROLE.equals("ROLE_USER")){
                usercomplain.add(complain.get(i));
            } else if (complain.get(i).ROLE.equals("ROLE_WORKER")) {
                workercomplain.add(complain.get(i));
            }
        }
        for (int i = 0; i<reports.size(); i++){
            if(reports.get(i).month==getcurrentmonth()){
                selected.add(reports.get(i));
            }
        }
//        for (int i = 0; i<usercomplain.size(); i++){
//            System.out.println(usercomplain.get(i).date);
//            System.out.println(usercomplain.get(i).getID());
//            System.out.println(usercomplain.get(i).getUsercomplain());
//            System.out.println(usercomplain.get(i).getUsermail());
//        }
        model.addAttribute("usercomplains", usercomplain);
        model.addAttribute("workercomplains", workercomplain);
        model.addAttribute("reports",selected);
        return "admin/index";
    }
    public int getcurrentmonth(){
        int month ;
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        month = cal.get(Calendar.MONTH);
        return month+1;
    }
}
