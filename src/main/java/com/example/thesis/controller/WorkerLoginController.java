package com.example.thesis.controller;

import com.example.thesis.Services.ReportService;
import com.example.thesis.Services.UserService;
import com.example.thesis.model.Report;
import com.example.thesis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/worker")
public class WorkerLoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @GetMapping("index")
    public String workerlogin(Principal principal, Model model){
        User user = userService.findByUserName(principal.getName());
        model.addAttribute("userinfo", user);
//        Month month1 = getcurrentmonth();
//        String month = String.valueOf(month1);
        System.out.println("worker "+String.valueOf(getcurrentmonth()));


        try{
//        List<Report> reports = reportService.findbyNameAndMonth("Jamal", DECEMBER) ;
            List<Report> reports = reportService.findAll();
            List<Report> selectedreports = new ArrayList<>();

            for(int i = 0; i<reports.size(); i++){
                if(reports.get(i).collector.equals(user.name) && reports.get(i).month==getcurrentmonth()){
                    selectedreports.add(reports.get(i));
//                    System.out.println(reports.get(i).date);
                }
            }
            model.addAttribute("reportinfo", selectedreports);
//            System.out.println(selectedreports.size());
//            System.out.println(reports.size());
        }
        catch (Exception e){
            e.printStackTrace();}
        return "worker/workerwelcome";
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
