package com.company;

import java.util.Scanner;

//16. Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3, ..., n*n
//так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между
//собой. Построить такой квадрат. Пример магического квадрата порядка 3:

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        if (N % 2 != 0) {
            System.out.println("Магический квадрат из нечетного количества элементов:");
            oddMagicSquare(N);
        } else if (N % 4 == 0) {
            System.out.println("Магический квадрат из четного количества элементов, кратного 4:");
            evenMatrixSquare(N);
        } else if ((N == 0) || (N == 2) || (N % 4 != 0))
            System.out.println("Для матрицы, с размерностью " + N + " магический квадрат создать не возможно...");
    }

    public static void evenMatrixSquare(int n) {
        int[][] matrix = standardMatrixFilling(n);
        int count = 0;
        for (int i = 0; i < n / 2; i++) {
            int transition;
            if (i < n / 2) {
                transition = matrix[i][i];
                matrix[i][i] = matrix[n - 1 - count][n - 1 - count];
                matrix[n - 1 - count][n - 1 - count] = transition;
                count++;
            }
        }
        count = 0;
        for (int i = 0; i < n / 2; i++) {
            int transition;
            if (i < n / 2) {
                transition = matrix[n - 1 - count][i];
                matrix[n - 1 - count][i] = matrix[i][n - 1 - count];
                matrix[i][n - 1 - count] = transition;
                count++;
            }
        }
        printMatrix(matrix);
    }

    public static void oddMagicSquare(int n) {
        int[][] matrix = new int[n][n];
        int i = 0, j = n / 2;
        for (int k = 1; k <= Math.pow(n,2); ++k) {
            matrix[i][j] = k;
            i--;
            j++;
            if (k % n == 0) {
                i += 2;
                --j;
            } else {
                if (j == n) {
                    j -= n;
                } else if (i < 0) {
                    i += n;
                }
            }
        }
        printMatrix(matrix);
    }

    public static int[][] standardMatrixFilling(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = count;
                count++;
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    public static void printMatrix(int matrix[][]) {
        for (int[] array : matrix) {
            for (int x : array) {
                System.out.print(x + "\t");
            }
            System.out.println();
        }
        System.out.println("");
    }
}
