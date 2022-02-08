package com.company;

import java.util.Scanner;

//Вычислить значения функции на отрезке [а,b] c шагом h:

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, h, x, i = 0;
        System.out.println("Границы отрезка [a,b]");
        System.out.println("Введите а: ");
        a = scanner.nextInt();
        System.out.println("Введите b: ");
        b = scanner.nextInt();
        System.out.println("Введите шаг h: ");
        h = scanner.nextInt();
        x = a;
        int[] X = new int[((b - a) / h) + 1];
        int[] Y = new int[((b - a) / h) + 1];
        while (x <= b) {
            X[i] = x;
            if (x > 2) {
                Y[i] = x;
            } else {
                Y[i] = -x;
            }
            x += h;
            ++i;
        }
        System.out.println("X  |  Y");
        for (i = 0; i < X.length; i++) {
            System.out.println(X[i] + " | " + Y[i]);
        }
    }
}
