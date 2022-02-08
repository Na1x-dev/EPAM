package com.company;

//5. Опишите класс, реализующий десятичный счетчик, который может увеличивать или уменьшать свое значение
//на единицу в заданном диапазоне. Предусмотрите инициализацию счетчика значениями по умолчанию и
//произвольными значениями. Счетчик имеет методы увеличения и уменьшения состояния, и метод
//позволяющее получить его текущее состояние. Написать код, демонстрирующий все возможности класса.

import java.util.Scanner;

class Counter {
    private int count;

    Counter() {
        this.count = 0;
    }

    Counter(int count) {
        this.count = count;
    }

    Counter(String str) {
        this.count = (int) (Math.random() * 1000);
    }

    public int getCount() {
        return count;
    }

    public int addCount() {
        return count++;
    }

    public int subCount() {
        return count--;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Counter count = new Counter();
        while (true) {
            System.out.println("Состояние счетчика: " + count.getCount());
            System.out.println("Выберите действие");
            System.out.println("1. Добавить 1");
            System.out.println("2. Вычесть 1");
            System.out.println("3. Инициализировать счетчик нулем");
            System.out.println("4. Инициализировать счетчик новым значением");
            System.out.println("5. Инициализировать счетчик случайным значением");
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    count.addCount();
                    break;
                case 2:
                    count.subCount();
                    break;
                case 3:
                    count = new Counter();
                    break;
                case 4:
                    System.out.println("Введите значение счетчика, которое вы хотите установить: ");
                    count = new Counter(scanner.nextInt());
                break;
                case 5:
                    count = new Counter("");
                    break;
            }
        }
    }
}