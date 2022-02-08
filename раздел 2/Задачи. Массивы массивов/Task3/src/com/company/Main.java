package com.company;

import java.util.Scanner;

//3. Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        System.out.println("Введите k - номер строки: ");
        int k = scanner.nextInt();
        System.out.println("Введите p - номер столбца: ");
        int p = scanner.nextInt();
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
        System.out.print(k + "-я строка:  ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[k][i] + " ");
        }
        System.out.println();
        System.out.print(p + "-й столбец: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i][p] + " ");
        }
        System.out.println();
    }
}
