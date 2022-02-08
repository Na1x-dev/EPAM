package com.company;

import java.util.Scanner;

//4. Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича. Определить, пройдет ли кирпич через
//отверстие.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Размеры отверстия");
        System.out.println("Введите первую сторону отверстия");
        int A = scanner.nextInt();
        System.out.println("Введите вторую сторону отверстия");
        int B = scanner.nextInt();
        System.out.println("Размеры кирпича");
        System.out.println("Введите первую сторону кирпича");
        int x = scanner.nextInt();
        System.out.println("Введите вторую сторону отверстия");
        int y = scanner.nextInt();
        System.out.println("Введите третью сторону отверстия");
        int z = scanner.nextInt();
        if (A >= x) {
            if (B >= y) {
                System.out.println("кирпич пролезет");
            }
        }
        if (A >= y) {
            if (B >= z) {
                System.out.println("кирпич пролезет");
            }
        }
        if (A >= z) {
            if (B >= x) {
                System.out.println("кирпич пролезет");
            }
        }
        if (B >= x) {
            if (A >= y) {
                System.out.println("кирпич пролезет");
            }
        }
        if (B >= y) {
            if (A >= z) {
                System.out.println("кирпич пролезет");
            }
        }
        if (B >= z) {
            if (A >= x) {
                System.out.println("кирпич пролезет");
            }
        }
    }
}
