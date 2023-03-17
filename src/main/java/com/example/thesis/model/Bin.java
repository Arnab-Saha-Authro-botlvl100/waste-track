package com.example.thesis.model;


import javax.persistence.*;

@Entity
@Table(name = "Bin")
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public String binname;
    public String binemail;
    public String binsize;
    public String binlong;
    public String binlati;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBinname() {
        return binname;
    }

    public void setBinname(String binname) {
        this.binname = binname;
    }

    public String getBinemail() {
        return binemail;
    }

    public void setBinemail(String binemail) {
        this.binemail = binemail;
    }

    public String getBinsize() {
        return binsize;
    }

    public void setBinsize(String binsize) {
        this.binsize = binsize;
    }

    public String getBinlong() {
        return binlong;
    }

    public void setBinlong(String binlong) {
        this.binlong = binlong;
    }

    public String getBinlati() {
        return binlati;
    }

    public void setBinlati(String binlati) {
        this.binlati = binlati;
    }
}
