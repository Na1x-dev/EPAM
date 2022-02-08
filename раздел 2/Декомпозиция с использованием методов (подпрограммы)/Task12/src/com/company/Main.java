package com.company;

import java.util.Scanner;

//12. Даны натуральные числа К и N. Написать метод(методы) формирования массива А, элементами которого
//являются числа, сумма цифр которых равна К и которые не большее N.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа K и N (К - сумма цифр элемента массива, N - максимально возможный элемент массива)");
        System.out.println("Введите число K: ");
        int K = scanner.nextInt();
        System.out.println("Введите число N: ");
        int N = scanner.nextInt();
        int[] array = numbersNotGreaterThanN(K, N);
        System.out.println("Массив чисел, которые не больше чем N и сумма цифр которых равна K: ");
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static int[] numbersNotGreaterThanN(int K, int N) {
        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (sumOfNumbers(arrayFromNumber(i)) == K) {
                count++;
            }
        }
        int[] mass = new int[count];
        int j = 0;
        for (int i = 0; i <= N; i++) {
            if (sumOfNumbers(arrayFromNumber(i)) == K) {
                mass[j] = i;
                j++;
            }
        }
        return mass;
    }

    public static int sumOfNumbers(int[] mass) {
        int sum = 0;
        for (int i = 0; i < mass.length; i++) {
            sum = sum + mass[i];
        }
        return sum;
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
