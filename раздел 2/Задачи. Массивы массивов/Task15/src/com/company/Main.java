package com.company;

import java.util.Scanner;

//15. Найдите наибольший элемент матрицы и заменить все нечетные элементы на него.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        int max = 0;
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 89 + 10);
                System.out.print(array[i][j] + " ");
                if (array[i][j] > max)
                    max = array[i][j];
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Наибольший элемент матрицы: " + max);
        System.out.println();
        System.out.println("Матрица с наибольшим элементов на местах нечетных элементов: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i][j] % 2 == 1)
                    array[i][j] = max;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
