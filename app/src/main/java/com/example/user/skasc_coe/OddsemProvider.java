package com.example.user.skasc_coe;

/**
 * Created by user on 1/18/2018.
 */

public class OddsemProvider {
    private String date;
    private  String schedule;

    public String getDate() {
        return date;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public OddsemProvider(String date, String schedule) {
        this.date = date;
        this.schedule = schedule;


    }
}
