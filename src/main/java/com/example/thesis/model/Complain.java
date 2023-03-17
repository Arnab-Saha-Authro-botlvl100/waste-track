package com.example.thesis.model;

import javax.persistence.*;

@Entity
@Table(name = "complain")
public class Complain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsercomplain() {
        return usercomplain;
    }

    public void setUsercomplain(String usercomplain) {
        this.usercomplain = usercomplain;
    }

    public String usercomplain;

    public String username;
    public String usermail;

    public String ROLE;

    public String complainreply;

    public String getReply() {
        return complainreply;
    }

    public void setReply(String reply) {
        this.complainreply = reply;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }

    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail;
    }
}
