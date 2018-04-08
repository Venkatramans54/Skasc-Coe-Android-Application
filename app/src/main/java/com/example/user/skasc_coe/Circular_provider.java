package com.example.user.skasc_coe;

/**
 * Created by user on 1/19/2018.
 */

public class Circular_provider {
    private String date;
    private String due;
    private  String schedule;


    public void setDate(String date) {
        this.date = date;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }


    public String getDate() {
        return date;

    }

    public String getSchedule() {
        return schedule;
    }

    public Circular_provider(String date, String schedule) {
        this.date = date;

        this.schedule = schedule;
    }


}
