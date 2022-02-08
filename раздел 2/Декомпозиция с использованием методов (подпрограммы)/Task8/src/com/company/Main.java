package com.company;

import java.util.Scanner;

//8. Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
//Пояснение. Составить метод(методы) для вычисления суммы трех последовательно расположенных элементов
//массива с номерами от k до m.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 20;
        int[] array = new int[N];
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 89 + 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Введите индекс элемента (1..." + (N - 2) + "), чтобы составить сумму из него и его соседей: ");
        int k = sc.nextInt();
        if (sumOfThreeElements(k, array) != -1)
            System.out.println("Сумма элементов с индексами " + (k - 1) + ", " + k + " и " + (k + 1) + " равна " + sumOfThreeElements(k, array));
        else
            System.out.println("Не возможно найти сумму элементов: выход за пределы массива");
    }

    public static int sumOfThreeElements(int k, int[] mass) {
        int sum;
        if (k > 0 && k < mass.length - 1) {
            sum = mass[k - 1] + mass[k] + mass[k + 1];
        } else {
            sum = -1;
        }
        return sum;
    }
}
