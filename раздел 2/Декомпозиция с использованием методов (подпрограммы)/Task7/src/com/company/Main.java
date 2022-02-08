package com.company;

//7. Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9

public class Main {

    public static void main(String[] args) {
        System.out.println("Сумма факториалов всех нечетных чисел от 1 до 9: " + factOneToNine());
    }

    public static int factOneToNine() {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            int factorial = 1;
            if (i % 2 == 1) {
                for (int j = 1; j <= i; j++) {
                    factorial*=j;
                }
                sum += factorial;
            }
        }
        return sum;
    }
}
