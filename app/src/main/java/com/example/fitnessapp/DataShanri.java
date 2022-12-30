package com.example.fitnessapp;

public class DataShanri {
    public String timer, date, steps;
    public DataShanri() {

    }

    public DataShanri(String date, String timer, String steps) {
        this.timer = timer;
        this.steps = steps;
        this.date = date;
    }
}