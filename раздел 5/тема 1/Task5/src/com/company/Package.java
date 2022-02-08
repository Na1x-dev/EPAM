package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

class Package {

    private String color;
    private String type;
    private int price;
    private int count;

    Package() {
        changePackage();
    }

    public void changePackage() {
        Scanner scanner = new Scanner(System.in);
        int key;
        System.out.println("Выберите материал упаковки");
        System.out.println("1. Фетр");
        System.out.println("2. Сетка");
        System.out.println("3. Пленка");
        System.out.println("4. Фоамиран");
        do {
            System.out.println("Выберите материал упаковки");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key){ //выбор типа упаковки
            case 1:
                this.type = "Фетр";
                this.price = 10;
                break;
            case 2:
                this.type = "Сетка";
                this.price = 7;
                break;
            case 3:
                this.type = "Пленка";
                this.price = 11;
                break;
            case 4:
                this.type = "Фоамиран";
                this.price = 13;
                break;
        }
        System.out.println("Выберите цвет");
        System.out.println("1. Красный");
        System.out.println("2. Желтый");
        System.out.println("3. Белый");
        System.out.println("4. Зеленый");
        do {
            System.out.println("Выберите цвет");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key){ //выбор цвета упаковки
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
                this.color = "Зеленый";
                break;
        }
        count = 1;
    }

    public void print(){
        System.out.println("    Материал: " + this.type + ", Цвет: " + this.color + ", Количество: " + this.count);
    }

    public int getCount() {
        return count;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void addCount(Package _package){
        this.count+=_package.getCount();
    }
}
