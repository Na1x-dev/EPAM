package com.company;

//8.Даны дроби. Составить программу, которая приводит эти дроби к общему
//знаменателю и упорядочивает их в порядке возрастания.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 4;
        int[] arrayOfNumerator = new int[N];
        int[] arrayOfDenominator = new int[N];
        System.out.println("Дроби: ");
        for (int i = 0; i < N; i++) {
            arrayOfNumerator[i] = (int) (Math.random() * 89 + 10);
            arrayOfDenominator[i] = (int) (Math.random() * 89 + 10);
            System.out.print(arrayOfNumerator[i] + "/" + arrayOfDenominator[i] + ", ");
        }
        int commonDenominator = arrayOfDenominator[0];
        for (int i = 1; i < N; i++) {
            commonDenominator = lcd(commonDenominator, arrayOfDenominator[i]); //расчет общего знаменателя
        }
        for (int i = 0; i < N; i++) {
            arrayOfNumerator[i] = arrayOfNumerator[i] * (commonDenominator / arrayOfDenominator[i]);
        }
        Arrays.sort(arrayOfNumerator);
        System.out.println();
        System.out.println("Приведенные и отсортированный дроби: ");
        for (int i = 0; i < N; i++)
            System.out.print(arrayOfNumerator[i] + "/" + commonDenominator + ", ");
        System.out.println();
    }

    public static int gcd(int a, int b) {
        int buf;
        while (b != 0) {
            buf = a % b;
            a = b;
            b = buf;
        }
        return a;
    }

    public static int lcd(int a, int b) {
        a = (a * b) / gcd(a, b);
        return a;
    }
}
