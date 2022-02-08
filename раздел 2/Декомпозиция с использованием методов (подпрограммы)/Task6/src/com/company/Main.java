package com.company;

import java.util.Scanner;

//6. Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = sc.nextInt();
        System.out.println("Введите второе число: ");
        int b = sc.nextInt();
        System.out.println("Введите третье число: ");
        int c = sc.nextInt();
        isRelativelyPrimeNumbers(a, b, c);
    }

    public static boolean isRelativelyPrimeNumbers(int a, int b, int c) {
        a = gcd(a, b);
        a = gcd(a, c);
        if (a == 1) {
            System.out.println("Числа являются взаимно простыми");
            return true;
        } else {
            System.out.println("Числа не являются взаимно простыми");
        }
        return false;
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
}
