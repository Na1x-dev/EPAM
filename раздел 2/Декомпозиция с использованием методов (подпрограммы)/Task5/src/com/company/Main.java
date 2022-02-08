package com.company;

//5. Составить программу, которая в массиве A[N] находит второе по величине число (вывести на печать число,
//которое меньше максимального элемента массива, но больше всех других элементов).

public class Main {

    public static void main(String[] args) {
        int N = 20;
        int[] X = new int[N];
        int max = 0;
        int max2 = 0;
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            X[i] = (int) (Math.random() * 89 + 10);
            System.out.print(X[i] + " ");
            if (X[i] > max)
                max = X[i];
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            if (X[i] > max2 && X[i] < max)
                max2 = X[i];
        }
        System.out.println("Второе по величине число в массиве: " + max2);
    }
}
