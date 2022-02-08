package com.company;

import java.util.Scanner;

//2. Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввеите 4 числа для нахождения НОД: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        System.out.println("НОД чисел " + a + ", " + b + ", " + c + " и " + d + ": " + gcd4(a, b, c, d));
    }

    public static int gcd4(int a, int b, int c, int d){
        a = gcd(a, b);
        a = gcd(a, c);
        a = gcd(a, d);
        return a;
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
