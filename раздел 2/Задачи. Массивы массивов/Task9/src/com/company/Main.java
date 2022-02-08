package com.company;

import java.util.Scanner;

//9. Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце. Определить, какой
//столбец содержит максимальную сумму.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int maxSum = 0, maxi = 0;
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        int[] sum = new int[N];
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 89 + 10);
                sum[j] = sum[j] + array[i][j];
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Суммы элементов в столбцах: ");
        for (int i = 0; i < N; i++) {
            System.out.print(i + " - "+ sum[i] + ", ");
            if (maxSum < sum[i]) {
                maxSum = sum[i];
                maxi = i;
            }
        }
        System.out.println();
        System.out.println("Максимальный столбец: " + maxi + ", максимальная сумма: " + maxSum);
    }
}
