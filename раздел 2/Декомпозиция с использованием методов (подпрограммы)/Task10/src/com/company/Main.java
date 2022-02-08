package com.company;

import java.util.Scanner;

//10. Дано натуральное число N. Написать метод(методы) для формирования массива, элементами которого
//являются цифры числа N.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число для формирования из цифр которого вы хотите получить массив: ");
        int N = scanner.nextInt();
        int[] array = arrayFromNumber(N);
        System.out.println("Массив из цифр числа: ");
        for (int i = 0; i < numberLength(N); i++)
            System.out.print(array[i] + ", ");
        System.out.println();
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
        int i=numberLength(N)-1;
        while (N != 0) {
            array[i] = N % 10;
            N = N / 10;
            i--;
        }
        return array;
    }

}
