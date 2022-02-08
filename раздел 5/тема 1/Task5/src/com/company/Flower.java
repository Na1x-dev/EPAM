package com.company;

import java.util.Scanner;

class Flower {
    private String color;
    private String type;
    private int price;
    private int count;


    Flower() {
        changeFlower();
    }

    public void changeFlower() { //выбор цветов
        Scanner scanner = new Scanner(System.in);
        int key;
        System.out.println("1. Роза");
        System.out.println("2. Тюльпан");
        System.out.println("3. Хризантема");
        System.out.println("4. Гвоздика");
        do {
            System.out.println("Выберите цветок");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key) { //выбор вида цветов
            case 1:
                this.type = "Роза";
                this.price = 28;
                break;
            case 2:
                this.type = "Тюльпан";
                this.price = 21;
                break;
            case 3:
                this.type = "Хризантема";
                this.price = 23;
                break;
            case 4:
                this.type = "Гвоздика";
                this.price = 19;
                break;
        }
        System.out.println("1. Красный");
        System.out.println("2. Желтый");
        System.out.println("3. Белый");
        System.out.println("4. Оранжевый");
        do {
            System.out.println("Выберите цвет");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key) { //выбор цвета цветов
            case 1:
                this.color = "Красный";
                break;
            case 2:
                this.color = "Желтый";
                break;
            case 3:
                this.color = "Белый";
                break;
            case 4:
                this.color = "Оранжевый";
                break;
        }
        do {
            System.out.println("Введите количество цветков: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            this.count = scanner.nextInt();
        } while (key <= 0);
    }

    public void print() {
        System.out.println("    Цветок: " + this.type + ", Цвет: " + this.color + ", Количество: " + this.count);
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public void addCount(Flower flower) {
        this.count += flower.getCount();

    }
}
