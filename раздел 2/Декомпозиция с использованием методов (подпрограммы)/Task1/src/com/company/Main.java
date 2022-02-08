package com.company;

import java.util.Scanner;

//1. Написать метод(методы) для нахождения наибольшего общего делителя и наименьшего общего кратного двух
//натуральных чисел:

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа для нахождения НОК и НОД: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("НОД чисел " + a + " и " + b + " : " + gcd(a, b));
        System.out.println("НОК чисел " + a + " и " + b + " : " + lcd(a, b));
    }

    public static int gcd(int a, int b) {
        int buf;
        while (b != 0) {
            buf = a % b;
            a = b;
            b = buf;
        }
        return a;
    }

    public static int lcd(int a, int b) {
        a = (a * b) / gcd(a, b);
        return a;
    }
}
