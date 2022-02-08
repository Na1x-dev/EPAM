package com.company;

public class Engine {
    String name;
    double volume;
    int cylinders;
    boolean turbocharged;
    int power;
    int torque;
    boolean isStarted = false;

    Engine(String name, double volume, int cylinders, boolean turbocharged, int power, int torque) {
        this.name = name;
        this.volume = volume;
        this.cylinders = cylinders;
        this.turbocharged = turbocharged;
        this.power = power;
        this.torque = torque;
    }

    public boolean getIsStarted() {
        return isStarted;
    }

    public void start() {
        isStarted = true;
        System.out.println("Двигатель запущен");
    }

    public void stop() {
        isStarted = false;
        System.out.println("Двигатель остановлен");
    }
}
