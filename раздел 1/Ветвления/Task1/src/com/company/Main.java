package com.company;

import java.util.Scanner;

//1. Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли
//он прямоугольным.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B;
        System.out.println("Введите угол A:");
        A = scanner.nextInt();
        System.out.println("Введите угол B:");
        B = scanner.nextInt();
        if (A + B > 0 && A + B < 180 && A != 0 && B != 0) {
            System.out.println("Треугольник существует.");
            if (A == 90)
                System.out.println("Треугольник прямоугольный.");
            if (B == 90)
                System.out.println("Треугольник прямоугольный.");
            if (180 - A - B == 90)
                System.out.println("Треугольник прямоугольный.");
        } else {
            System.out.println("Треугольник не существует.");
        }
    }
}
