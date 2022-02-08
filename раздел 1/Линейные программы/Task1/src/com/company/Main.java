package com.company;

import java.util.Scanner;

//1. Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.

public class Main {

    public static void main(String[] args) {
        float a, b, c, z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a: ");
        a = scanner.nextFloat();
        System.out.println("Введите b: ");
        b = scanner.nextFloat();
        System.out.println("Введите c: ");
        c = scanner.nextFloat();
        z = ((a - 3) * b / 2) + c;
        System.out.println("z =  " + z);
    }
}
