package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FlowerArrangement {
    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Package> packages = new ArrayList<>();
    private int price;

    FlowerArrangement() {
    }

    public void createFlowerArrangement() {
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        boolean newArrangement = true;
        while (true) {
            if (newArrangement) {
                System.out.println("Собираем новую композицию");
                newArrangement = false;
            }
            print();
            System.out.println("1. Добавить цветок");
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
                case 1:
                    addFlower();
                    break;
                case 2:
                    addPackage();
                    break;
                case 3:
                    buy();
                    newArrangement = true;
                    break;
            }
        }

    }

    public void addFlower() {
        Flower bufFlower = new Flower();
        boolean enters = false;
        for (Flower flower : flowers) { //проверка на наличие уже подобных цветов в композиции
            if (flower.getColor().equals(bufFlower.getColor()) && flower.getType().equals(bufFlower.getType())) {
                enters = true; //если есть, то добавляем к прошлым
                flower.addCount(bufFlower);
            }
        }
        if (!enters) { //если нет - добавляем как новые
            this.flowers.add(bufFlower);
        }
    }

    public void addPackage() {
        Package bufPackage = new Package();
        boolean enters = false;
        for (Package _package : packages) { //проверка на наличие уже подобной упаковки в композиции
            if (_package.getColor().equals(bufPackage.getColor()) && _package.getType().equals(bufPackage.getType())) {
                enters = true; //если есть, то добавляем к прошлой
                _package.addCount(bufPackage);
            }
        }
        if (!enters) { //если нет, то добавляем как новую
            this.packages.add(bufPackage);
        }
    }

    public void print() { //вывести содержимое композиции на экран
        System.out.println("-----------------------------------------");
        System.out.println("Композиция состоит из таких цветов как: ");
        this.price = 0;
        for (Flower flower : flowers) {
            flower.print();
            this.price = this.price + (flower.getPrice() * flower.getCount());
        }
        System.out.println("Которые упакованы в: ");
        for (Package _package : packages) {
            _package.print();
            this.price = this.price + (_package.getPrice() * _package.getCount());
        }
        System.out.println("Стоимость композиции: " + this.price + "$");
        System.out.println("-----------------------------------------");
    }

    public void buy() { //приобрести композицию
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Продолжить выбор элементов композиции");
        System.out.println("2. Приобрести композицию");
        int key;
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >= 3);
        if (key == 2) {
            System.out.println("С вас " + price + "$");
            System.out.println("Спасибо за покупку!");
            flowers.clear();
            packages.clear();
            price = 0;
            System.out.println();
        }
    }
}
