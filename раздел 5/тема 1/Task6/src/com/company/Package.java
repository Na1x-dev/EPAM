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
        System.out.println("Выберите тип упаковки");
        System.out.println("1. Коробка");
        System.out.println("2. Упаковочная бумага");
        System.out.println("3. Ленточка");
        System.out.println("4. Стружка");
        do {
            System.out.println("Выберите тип упаковки");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >=5);
        switch (key){ //выбор типа упаковки
            case 1:
                this.type = "Коробка";
                this.price = 4;
                break;
            case 2:
                this.type = "Упаковочная бумага";
                this.price = 2;
                break;
            case 3:
                this.type = "Ленточка";
                this.price = 1;
                break;
            case 4:
                this.type = "Стружка";
                this.price = 4;
                break;
        }
        System.out.println("Выберите цвет");
        System.out.println("1. Красный");
        System.out.println("2. Желтый");
        System.out.println("3. Белый");
        System.out.println("4. Синий");
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
                this.color = "Синий";
                break;
        }
        count = 1;
    }

    public void print(){ //вывод на экран
        System.out.println("    Тип упаковки: " + this.type + ", Цвет: " + this.color + ", Количество: " + this.count);
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
