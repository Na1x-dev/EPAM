package com.company;

import java.util.Scanner;

//7. Даны действительные числа a1, a2, ..., an. Найти max( , , , ) a1 + a2n a2 + a2n−1 , ..., an + an+1.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число n (размерность массива 2*n): ");
        int n = sc.nextInt();
        int[] array = new int[2 * n];
        System.out.println("Массив: ");
        for (int i = 0; i < 2 * n; i++) {
            array[i] = (int) (Math.random() * 89 + 10);
            System.out.print(array[i] + ", ");
        }
        int max = 0;
        System.out.println();
        for (int i = 0; i < n; i++) {
            int max1 = array[i] + array[2 * n - i - 1];
            if (max1 > max) {
                max = max1;
            }
        }
        System.out.println("max(a1 + a2n, a2 + a2n−1,...,an + an+1) = " + max);
        System.out.println();
    }
}
