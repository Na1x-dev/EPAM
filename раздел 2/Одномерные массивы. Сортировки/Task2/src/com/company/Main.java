package com.company;

//2. Даны две последовательности
//a1 =< a2 =<...=< an и b1 =< b2 =<...=< bm
//. Образовать из них новую последовательность
//чисел так, чтобы она тоже была неубывающей. Примечание. Дополнительный массив не использовать.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int N1 = (int) (Math.random() * 9 + 10);
        int N2 = (int) (Math.random() * 9 + 10);
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
        int[] res = new int[N1 + N2];
        for (int i = 0; i < N1; i++) {
            res[i] = array1[i];
        }
        for (int i = 0; i < N2; i++) {
            res[i + N1] = array2[i];
        }
        Arrays.sort(res);
        System.out.println("Новый отсортированный массив: ");
        for (int i = 0; i < N1 + N2; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
