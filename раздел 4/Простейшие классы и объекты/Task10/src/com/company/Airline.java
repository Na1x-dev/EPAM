package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Airline {
    private String destination;
    private int flightNumber;
    private String aircraftType;
    private String departureTime;
    private ArrayList<String> daysOfWeek;

    Airline(String destination, int flightNumber, String aircraftType, String departureTime, String[] daysOfWeek) {

        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.daysOfWeek = new ArrayList<>();
        this.daysOfWeek.addAll(Arrays.asList(daysOfWeek));
    }

    Airline() {

        this.destination = "Минск";
        this.flightNumber = 647;
        this.aircraftType = "Boeing 747";
        this.departureTime = "16:32";
        String[] daysOfWeek = new String[]{"понедельник", "среда", "пятница"};
        this.daysOfWeek = new ArrayList<>();
        this.daysOfWeek.addAll(Arrays.asList(daysOfWeek));
    }


    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public ArrayList<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                ", destination='" + destination + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", aircraftType='" + aircraftType + '\'' +
                ", departureTime=" + departureTime +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }

    public void print() {
        System.out.println(
                ", Место назначения: " + destination +
                        ", Номер рейса: " + flightNumber +
                        ", Тип Самолета: " + aircraftType +
                        ", Время отправления: " + departureTime +
                        ", дни недели: " + daysOfWeek);
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setDaysOfWeek(String[] daysOfWeek) {
        this.daysOfWeek = new ArrayList<>();
        this.daysOfWeek.addAll(Arrays.asList(daysOfWeek));
    }

    public static Airline setAirline() {
        Scanner scanner = new Scanner(System.in);
        Airline airline = new Airline("", 0, "", "", new String[]{""});
        System.out.print("Пункт назначения: ");
        airline.destination = scanner.next();
        System.out.print("Номер рейса: ");
        airline.flightNumber = scanner.nextInt();
        System.out.print("Тип самолета: ");
        airline.aircraftType = scanner.next();
        System.out.print("Время отправления: ");
        airline.departureTime = scanner.next();
        int N;
        while (true) {
            System.out.println("Количество дней в неделю: ");
            N = scanner.nextInt();
            if (N < 8)
                break;
        }
        for (int i = 0; i < N; i++) {
            System.out.print("День недели: ");
            airline.daysOfWeek.add(i, scanner.next());
        }
        airline.daysOfWeek.remove(airline.daysOfWeek.size()-1);
        return airline;
    }

    public int compare(Airline airline, String time) {
        return airline.departureTime.compareTo(time);
    }
}