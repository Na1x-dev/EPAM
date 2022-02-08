package com.company;

import java.util.Scanner;

//8. В числовой матрице поменять местами два столбца любых столбца, т. е. все элементы одного столбца поставить
//на соответствующие им позиции другого, а его элементы второго переместить в первый. Номера столбцов вводит
//пользователь с клавиатуры.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = scanner.nextInt();
        System.out.println("Введите номер первого столбца для перемещения: ");
        int j1 = scanner.nextInt();
        System.out.println("Введите номер второго столбца для перемещения: ");
        int j2 = scanner.nextInt();
        int[][] array = new int[N][N];
        int[] buf = new int[N];
        System.out.println("Матрица: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = (int) (Math.random() * 89 + 10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            buf[i] = array[i][j1];
            array[i][j1] = array[i][j2];
            array[i][j2] = buf[i];
        }
        System.out.println();
        System.out.println("Матрица после перемещения " + j1 + "-го и " + j2 + "-го столбцов: ");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
