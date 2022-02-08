package com.company;

//1. Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент больше последнего.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 89 + 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Нечетные столбцы, у которых первый элемент больше последнего: ");
        for (int i = 0; i < N; i++) {
            if ((array[0][i] > array[N - 1][i]) && (i % 2 == 1)) {
                System.out.print("Столбец с индексом " + i + ": ");
                for (int j = 0; j < N; j++)
                    System.out.print(array[j][i] + " ");
                System.out.println();
            }
        }
    }
}
