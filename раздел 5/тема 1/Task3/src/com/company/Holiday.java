package com.company;

public class Holiday {
    int day;
    int month;
    String name;

    Holiday(int day, int month, String name){
        this.day = day;
        this.month = month;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }
}
