package com.company;

import java.util.ArrayList;
import java.util.Scanner;

//1. Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
//один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
//дополнительный массив.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = (int) (Math.random() * 9 + 10);
        int N2 = (int) (Math.random() * 9 + 10);
        int k = 100;
        int[] array1 = new int[N1];
        int[] array2 = new int[N2];
        System.out.println("Первый массив: ");
        for (int i = 0; i < N1; i++) {
            array1[i] = (int) (Math.random() * 89 + 10);
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        System.out.println("Второй массив: ");
        for (int i = 0; i < N2; i++) {
            array2[i] = (int) (Math.random() * 89 + 10);
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        System.out.println("Введите число от 0 до " + (N1-2) + " для разделения массива: ");
        while (k < 0 || k > (N1-2)) {
            k = sc.nextInt();
        }
        ArrayList<Integer> notArray = new ArrayList<>();
        for (int i = 0; i < k + 1; i++)
            notArray.add(array1[i]);
        for (int i = 0; i < N2; i++)
            notArray.add(array2[i]);
        for (int i = k + 1; i < N1; i++)
            notArray.add(array1[i]);
        array1 = new int[N1 + N2];
        for (int i = 0; i < N1 + N2; i++) {
            array1[i] = notArray.get(i);
            System.out.print(array1[i] + " ");
        }
    }
}
