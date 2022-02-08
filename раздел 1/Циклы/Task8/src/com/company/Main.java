package com.company;

import java.util.Scanner;

//8. Даны два числа. Определить цифры, входящие в запись как первого так и второго числа.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int A = scanner.nextInt();
        int A2;
        System.out.println("Введите второе число: ");
        int B = scanner.nextInt();
        int B1, B2;
        int n1, n2, n3;
        System.out.println();
        n1 = String.valueOf(A).length();
        n2 = String.valueOf(B).length();
        if (n1 < n2)
            n3 = n2;
        else
            n3 = n1;
        int k = 0;
        int[] N = new int[n3];
        for (int i = 0; i < n1; i++) {
            A2 = A % 10;
            A = A / 10;
            B1 = B;
            for (int j = 0; j < n2; j++) {
                B2 = B1 % 10;
                B1 = B1 / 10;
                if (A2 == B2) {
                    N[k] = A2;
                    k++;
                }
            }
        }
        System.out.println("Цифры входящие как в первое, так и во второе число: ");
        for (int i = 0; i < k; i++) {
            System.out.print(N[i] + ", ");
        }
    }
}
