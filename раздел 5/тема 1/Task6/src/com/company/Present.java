package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Present {
    DecimalFormat f = new DecimalFormat("##.00");
    private ArrayList<Candy> candies = new ArrayList<>();
    private ArrayList<Package> packages = new ArrayList<>();
    private double price;

    Present() {
    }

    public void createPresent() { //создание нового подарка
        Scanner scanner = new Scanner(System.in);
        int key;
        boolean newArrangement = true;
        while (true) {
            if(newArrangement){
                System.out.println("Собираем новую подарок");
                newArrangement = false;
            }
            print(); //вывод подарка на экран
            System.out.println("1. Добавить конфет");
            System.out.println("2. Добавить упаковку");
            System.out.println("3. Продолжить");
            do {
                System.out.println("Выберите пункт меню");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                key = scanner.nextInt();
            } while (key <= 0 || key >= 4);
            switch (key) {
                case 1 -> addCandies();
                case 2 -> addPackage();
                case 3 -> {
                    buy();
                    newArrangement = true;
                }
            }
        }

    }

    public void addCandies() { //добавить конфеты
        Candy bufCandy = new Candy();
        boolean enters = false;
        for (Candy candy : candies) { //есть ли такие конфеты уже в подарке
            if (candy.getManufacturer().equals(bufCandy.getManufacturer()) && candy.getType().equals(bufCandy.getType())) {
                enters = true; //если есть - новый объект не создавать
                candy.addCount(bufCandy);
            }
        }
        if (!enters) { //иначе добавить как новый объект
            this.candies.add(bufCandy);
        }
    }

    public void addPackage() { //добавить упаковку
        Package bufPackage = new Package();
        boolean enters = false;
        for (Package _package : packages) { //есть ли такая упаковка уже в подарке
            if (_package.getColor().equals(bufPackage.getColor()) && _package.getType().equals(bufPackage.getType())) {
                enters = true; //если есть - новый объект не создавать
                _package.addCount(bufPackage);
            }
        }
        if (!enters) { //иначе добавить как новый объект
            this.packages.add(bufPackage);
        }
    }

    public void print() { //вывод содержимого подарка
        System.out.println("-----------------------------------------");
        System.out.println("Подарок состоит из таких конфет как: ");
        this.price = 0;
        for (Candy candy : candies) {
            candy.print();
            this.price = this.price + (candy.getPrice() * candy.getCount());
        }
        System.out.println("Которые упакованы в: ");
        for (Package _package : packages) {
            _package.print();
            this.price = this.price + (_package.getPrice()  * _package.getCount());
        }
        System.out.println("Стоимость подарка: " + f.format(this.price) + "$");
        System.out.println("-----------------------------------------");
    }

    public void buy() { //купить подарок
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Продолжить выбор элементов подарка");
        System.out.println("2. Приобрести подарок");
        int key;
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >= 3);
        if(key==2){
            System.out.println("С вас " + price + "$");
            System.out.println("Спасибо за покупку!");
            candies.clear();
            packages.clear();
            price = 0;
            System.out.println();
        }
    }
}
