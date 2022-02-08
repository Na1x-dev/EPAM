package com.company;

import java.util.Scanner;

public class Main {

    //2. Найти max{min(a, b), min(c, d)}.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d, minAB, minDC, max;
        System.out.println("Введите а: ");
        a = scanner.nextInt();
        System.out.println("Введите b: ");
        b = scanner.nextInt();
        System.out.println("Введите c: ");
        c = scanner.nextInt();
        System.out.println("Введите d: ");
        d = scanner.nextInt();
        if (a < b)
            minAB = a;
        else
            minAB = b;
        if (c < d)
            minDC = c;
        else
            minDC = d;
        if (minAB > minDC)
            max = minAB;
        else
            max = minDC;

        System.out.println("максимум из минимумов: " + max);
    }
}
