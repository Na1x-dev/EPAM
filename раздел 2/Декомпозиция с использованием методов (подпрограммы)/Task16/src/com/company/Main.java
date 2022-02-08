package com.company;

//16. Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
//Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество цифр в числе: ");
        int n = scanner.nextInt();
        int sum = sumOfOddNumbers(n);
        System.out.println();
        System.out.println("Сумма чисел с нечетными цифрами: " + sum);
        System.out.println("Количество четных цифр в найденной сумме: " + countOfEvenNumbers(arrayFromNumber(sum)));
        System.out.println();
    }

    public static boolean numeralsIsOdd(int[] array) {
        for (int number : array) {
            if (number % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfOddNumbers(int n) {
        int sum = 0;
        System.out.println(n+"-значные числа, содержащие только нечетные цифры: ");
        for (int i = (int) Math.pow(10, n - 1); i < (int) Math.pow(10, n); i++) {
            if (numeralsIsOdd(arrayFromNumber(i))) {
                sum = sum + i;
                System.out.print(i + ", ");
            }
        }
        return sum;
    }

    public static int countOfEvenNumbers(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int numberLength(int N) {
        int length = 0;
        while (N != 0) {
            N = N / 10;
            length++;
        }
        return length;
    }

    public static int[] arrayFromNumber(int N) {
        int[] array = new int[numberLength(N)];
        int i = numberLength(N) - 1;
        while (N != 0) {
            array[i] = N % 10;
            N = N / 10;
            i--;
        }
        return array;
    }
}
