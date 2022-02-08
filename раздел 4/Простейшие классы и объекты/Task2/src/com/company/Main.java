package com.company;

//2. Создйте класс Test2 двумя переменными. Добавьте конструктор с входными параметрами. Добавьте
//конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get- методы для полей экземпляра
//класса.

import java.util.Scanner;

class Test2 {
    private int a;
    private int b;

    Test2() {
        this.a = 41;
        this.b = 68;
    }

    Test2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }
}


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test2 testObject1 = new Test2();
        Test2 testObject2 = new Test2(87, 23);

        System.out.println("Переменная А первого объекта: " + testObject1.getA());
        System.out.println("Переменная В первого объекта: " + testObject1.getB());

        System.out.println("Введите новое значение переменной А: ");
        testObject1.setA(scanner.nextInt());
        System.out.println("Введите новое значение переменной В: ");
        testObject1.setB(scanner.nextInt());

        System.out.println("Переменная А первого объекта после изменения: " + testObject1.getA());
        System.out.println("Переменная В первого объекта после изменения: " + testObject1.getB());

        System.out.println("Переменная А второго объекта: " + testObject2.getA());
        System.out.println("Переменная В второго объекта: " + testObject2.getB());
    }
}
