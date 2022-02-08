package com.company;

import java.util.Scanner;

//14. Натуральное число, в записи которого n цифр, называется числом Армстронга, если сумма его цифр,
//возведенная в степень n, равна самому числу. Найти все числа Армстронга от 1 до k. Для решения задачи
//использовать декомпозицию.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, для определения интервала [0, k]: ");
        int k = scanner.nextInt();
        System.out.println("Числа Армстронга: ");
        for (int i = 1; i <= k; i++) {
            if (isArmstrongNumber(massFromNum(i), numberLength(i), i)) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public static boolean isArmstrongNumber(int[] mass, int n, int number) {
        boolean res = false;
        int sum = 0;
        for (int j : mass) {
            sum = (int) (sum + Math.pow(j, n));
        }
        if (sum == number)
            res = true;
        return res;
    }

    public static int[] massFromNum(int N) {
        int[] array = new int[numberLength(N)];
        int i = numberLength(N) - 1;
        while (N != 0) {
            array[i] = N % 10;
            N = N / 10;
            i--;
        }
        return array;
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
