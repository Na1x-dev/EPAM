package com.company;

import java.util.Scanner;

//10. Найти положительные элементы главной диагонали квадратной матрицы.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 100 - 50);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Положительные числа главной диагонали матрицы: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j && array[i][j] > 0)
                    System.out.print(array[i][j] + ", ");
            }
        }
        System.out.println();
    }
}
