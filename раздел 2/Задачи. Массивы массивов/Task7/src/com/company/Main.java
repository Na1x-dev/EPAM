package com.company;

import java.util.Scanner;

//7. Сформировать квадратную матрицу порядка N по правилу и подсчитать количество положительных элементов в ней.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        double[][] array = new double[N][N];
        int countPositiveElements = 0;
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = Math.sin((Math.pow(i, 2) - Math.pow(j, 2)) / N);
                if (array[i][j] > 0)
                    countPositiveElements++;
                String number = String.format("%.2f", array[i][j]);
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Количество положительных элементов в матрице: " + countPositiveElements);
    }
}
