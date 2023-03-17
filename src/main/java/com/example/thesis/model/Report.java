package com.example.thesis.model;

import javax.persistence.*;
import java.time.Month;

@Entity
@Table(name = "Report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int ID;

    public String collector;
    public String date;
    public int count;
    public String time;
    public String useremail;
    public int month;
    public double tk;

    public int getID(){
        return ID;
    }
    public void setID(int id){
        this.ID = id;
    }
    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTk() {
        return tk;
    }

    public void setTk(double tk) {
        this.tk = tk;
    }
}
