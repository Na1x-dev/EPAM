package com.company;

import java.util.Comparator;

public class TravelVoucher {
    private String type;
    private int duration;
    private String transport;
    private int food;
    private int price;

    TravelVoucher(String type, int duration, String transport, int food, int price) {
        this.type = type;
        this.duration = duration;
        this.transport = transport;
        this.food = food;
        this.price = price;
    }

    public void printVoucher() {
        System.out.println("Тип путевки: " + this.type);
        System.out.println("Длительность путевки: " + this.duration);
        System.out.println("Тип транспорта: " + this.transport);
        System.out.println("Количество приемов пищи: " + this.food);
        System.out.println("Цена путевки: " + this.price);
    }

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public String getTransport() {
        return transport;
    }

    public int getFood() {
        return food;
    }

    public int getPrice() {
        return price;
    }
}
