package com.company;

import java.util.Scanner;

//2. Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.

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
        System.out.println("Элементы, стоящие на диагонали: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
    }
}
