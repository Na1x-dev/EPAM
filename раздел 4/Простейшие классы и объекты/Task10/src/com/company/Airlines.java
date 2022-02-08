package com.company;

import java.util.ArrayList;


public class Airlines {
    private ArrayList<Airline> airlines;

    Airlines() {
        this.airlines = new ArrayList<>();
    }

    public void addAirline(Airline airline) {
        airlines.add(airline);
    }

    public void print() {
        for (Airline airline : airlines) {
            airline.print();
        }
    }

    public void flightOfDestination(String destination) {
        for(Airline airline : airlines) {
            if(airline.getDestination().equals(destination)){
                airline.print();
            }
        }
    }

    public void forDayOfWeek(String day) {
        for(Airline airline : airlines){
            for(String s : airline.getDaysOfWeek()){
                if(s.equals(day)){
                    airline.print();
                    break;
                }
            }
        }
    }

    public void forDayAndTime(String day, String time) {
        for(Airline airline : airlines){
            if(airline.compare(airline, time)>0) {
                for (String s : airline.getDaysOfWeek()) {
                    if (s.equals(day)) {
                        airline.print();
                        break;
                    }
                }
            }
        }
    }
}