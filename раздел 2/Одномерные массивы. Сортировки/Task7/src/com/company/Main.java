package com.company;

import java.util.ArrayList;
import java.util.Arrays;

//7. Пусть даны две неубывающие последовательности действительных чисел
//a1 <= a2 <=...<= an и b1 <= b2 <=...<= bm
//.
//Требуется указать те места, на которые нужно вставлять элементы последовательности
//b1 <= b2 <=...<= bm
//в первую
//последовательность так, чтобы новая последовательность оставалась возрастающей.

public class Main {
    public static void main(String[] args) {
        int N1 = 10;
        int N2 = 10;
        int[] array1 = new int[N1];
        int[] array2 = new int[N2];
        for (int i = 0; i < N1; i++) {
            array1[i] = (int) (Math.random() * 89 + 10);
            array2[i] = (int) (Math.random() * 89 + 10);
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        ArrayList<Integer> places = new ArrayList<>();
        for (int i = 1; i < N1; i++) {
            if (array1[0] >= array2[i - 1]) {
                places.add(0);
            }
            for (int j = 0; j < N2; j++) {
                if (array1[i - 1] < array2[j] && array1[i] >= array2[j]) {
                    places.add(i);
                } else if (array1[array1.length - 1] < array2[j] && array1[array1.length - 1] == array1[i]) {
                    places.add(i + 1);
                }
            }
        }
        System.out.println();
        System.out.println("Первый массив: ");
        for (int i = 0; i < N1; i++)
            System.out.print(array1[i] + " ");
        System.out.println();
        System.out.println("Второй массив: ");
        for (int i = 0; i < N2; i++)
            System.out.print(array2[i] + " ");
        System.out.println();
        System.out.println("Места в первом массиве, на которые нужно вставить элементы второго массива, чтобы остался порядок: ");
        System.out.println(places);
        System.out.println();
    }
}
