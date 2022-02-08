package com.company;

import java.util.Scanner;

//13. Отсотрировать стобцы матрицы по возрастанию и убыванию значений эементов.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        int buf;
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 89 + 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N - 1; k++) {
                for (int i = 0; i < N - 1 - k; i++) {
                    if (array[i][j] > array[i + 1][j]) {
                        buf = array[i][j];
                        array[i][j] = array[i + 1][j];
                        array[i + 1][j] = buf;
                    }
                }
            }
        }
        System.out.println("Матрица с отсортированными столбцами по возрастанию: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < N - 1; k++) {
                for (int i = 0; i < N - 1 - k; i++) {
                    if (array[i][j] < array[i + 1][j]) {
                        buf = array[i][j];
                        array[i][j] = array[i + 1][j];
                        array[i + 1][j] = buf;
                    }
                }
            }
        }
        System.out.println("Матрица с отсортированными столбцами по убыванию: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
