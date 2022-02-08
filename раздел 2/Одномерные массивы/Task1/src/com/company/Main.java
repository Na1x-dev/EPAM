package com.company;

import java.util.Scanner;

//1. В массив A [N] занесены натуральные числа. Найти сумму тех элементов, которые кратны данному К.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        System.out.println("Введите число К: ");
        int K = sc.nextInt();
        int sum = 0;
        int[] A = new int[N];
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            A[i] = (int) (Math.random() * 100);
            System.out.print(A[i] + ", ");
            if (A[i] % K == 0) {
                sum = sum + A[i];
            }
        }
        System.out.println();
        System.out.println("Сумма элементов кратных К: " + sum);
    }
}
