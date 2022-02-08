package com.company;

//1. Создайте класс Test1 двумя переменными. Добавьте метод вывода на экран и методы изменения этих
//переменных. Добавьте метод, который находит сумму значений этих переменных, и метод, который находит
//наибольшее значение из этих двух переменных.

import java.util.Scanner;

class Test1{
    private int a;
    private int b;

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

    public int sumAB(){
        return a + b;
    }

    public int getBiggestAB() {
        return Math.max(a, b);
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test1 testObject = new Test1();
        System.out.println("Введите число А: ");
        testObject.setA(scanner.nextInt());
        System.out.println("Введите число В: ");
        testObject.setB(scanner.nextInt());
        System.out.println("Число А: " + testObject.getA());
        System.out.println("Число B: " + testObject.getB());
        System.out.println("Сумма А и В: " + testObject.sumAB());
        System.out.println("Максимальное число из А и В: " + testObject.getBiggestAB());
    }
}
