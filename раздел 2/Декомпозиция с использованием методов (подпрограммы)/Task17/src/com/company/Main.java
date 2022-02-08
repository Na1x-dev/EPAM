package com.company;

import java.util.Scanner;

//17. Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. Сколько таких
//действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        int number = scanner.nextInt();
        System.out.println("Количество вычитаний суммы цифр из числа: " + countOfMinus(number));
        System.out.println();
    }

    public static int sumOfNumbers(int[] mass) {
        int sum = 0;
        for (int j : mass) {
            sum = sum + j;
        }
        return sum;
    }

    public static int countOfMinus(int number) {
        int count = 0;
        int sum = sumOfNumbers(arrayFromNumber(number));
        while (number > 0) {
            number -= sum;
            count++;
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
