package com.company;

import java.util.Scanner;

//11. Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа (a и b) для сравнения их длины");
        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();
        switch (lengthOfNumbers(a, b)){
            case -1:
                System.out.println("Число b имеет больше цифр, чем число а");
                break;
            case 0:
                System.out.println("Числа a и b имеют одинаковое количество цифр");
                break;
            case 1:
                System.out.println("Число a имеет больше цифр, чем число b");
                break;
        }
    }

    public static int lengthOfNumbers(int a, int b) {
        int res = 0;
        if (numberLength(a) > numberLength(b)) {
            res = 1;
        } else if (numberLength(a) < numberLength(b)) {
            res = -1;
        }
        return res;
    }

    public static int numberLength(int N) {
        int length = 0;
        while (N != 0) {
            N = N / 10;
            length++;
        }
        return length;
    }
}
