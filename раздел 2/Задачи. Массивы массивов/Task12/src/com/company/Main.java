package com.company;

import java.util.Scanner;

//12. Отсортировать строки матрицы по возрастанию и убыванию значений элементов.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите размерность массива: ");
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
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N - 1; k++) {
                for (int j = 0; j < N - 1 - k; j++) {
                    if (array[i][j] > array[i][j + 1]) {
                        buf = array[i][j];
                        array[i][j] = array[i][j + 1];
                        array[i][j + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Матрица с отсортированными строками по возрастанию: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N - 1; k++) {
                for (int j = 0; j < N - 1 - k; j++) {
                    if (array[i][j] < array[i][j + 1]) {
                        buf = array[i][j];
                        array[i][j] = array[i][j + 1];
                        array[i][j + 1] = buf;
                    }
                }
            }
        }
        System.out.println("Матрица с отсортированными строками по убыванию: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
