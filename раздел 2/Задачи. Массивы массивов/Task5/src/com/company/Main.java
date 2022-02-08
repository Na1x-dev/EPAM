package com.company;

import java.util.Scanner;

//5. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива (четная): ");
        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        System.out.println("Матрица по шаблону: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - i)
                    array[i][j] = i + 1;
                else
                    array[i][j] = 0;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
