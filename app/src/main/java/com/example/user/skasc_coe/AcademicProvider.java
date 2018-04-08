package com.example.user.skasc_coe;

/**
 * Created by user on 1/17/2018.
 */

public class AcademicProvider  {
    private String date;
    private  String committee;

    public AcademicProvider(String committee,String date) {
        this.date = date;
        this.committee = committee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getCommittee() {

        return committee;

    }
}
