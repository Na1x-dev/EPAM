package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

class Candy {

    private String manufacturer;
    private String type;
    private double price;
    private int count;

    Candy() {
        changeFlower();
    }

    public void changeFlower() {
        Scanner scanner = new Scanner(System.in);
        int key;
        System.out.println("1. Помадная");
        System.out.println("2. Сбивная");
        System.out.println("3. Желейная");
        System.out.println("4. Грильяж");
        do {
            System.out.println("Выберите тип конфеты");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key) { //выбор типа конфеты
            case 1:
                this.type = "Помадная";
                this.price = 0.03;
                break;
            case 2:
                this.type = "Сбивная";
                this.price = 0.02;
                break;
            case 3:
                this.type = "Желейная";
                this.price = 0.003;
                break;
            case 4:
                this.type = "Грильяж";
                this.price = 0.005;
                break;
        }
        System.out.println("1. Nestle");
        System.out.println("2. Roshen");
        System.out.println("3. Ferrero");
        System.out.println("4. Mars");
        do {
            System.out.println("Выберите производителя");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key) { //выбор производителя конфет
            case 1:
                this.manufacturer = "Nestle";
                this.price *= 1.2;
                break;
            case 2:
                this.manufacturer = "Roshen";
                this.price *= 1;
                break;
            case 3:
                this.manufacturer = "Ferrero";
                this.price *= 1.4;
                break;
            case 4:
                this.manufacturer = "Mars";
                this.price *= 1.1;
                break;
        }
        do {
            System.out.println("Введите количество конфет, гр: ");
            while (!scanner.hasNextInt()) { //выбор количества конфет
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            this.count = scanner.nextInt();
        } while (key <= 0);
    }

    public void print() {
        System.out.println("    Тип конфеты: " + this.type + ", Производитель: " + this.manufacturer + ", Количество: " + this.count + " гр");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void addCount(Candy candy) {
        this.count += candy.getCount();
    }
}
