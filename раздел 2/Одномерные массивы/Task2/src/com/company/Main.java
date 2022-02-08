package com.company;

//2. Дана последовательность действительных чисел а1 ,а2 ,..., ап. Заменить все ее члены, большие данного Z, этим
//числом. Подсчитать количество замен.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("введите размерность массива: ");
        int N = sc.nextInt();
        System.out.println("введите число Z: ");
        int Z = sc.nextInt();

        int[] array = new int[N];
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            System.out.print(array[i] + ", ");
            if (array[i] > Z) {
                array[i] = Z;
                count++;
            }
        }
        System.out.println("количество замен на число Z: " + count);
    }
}
