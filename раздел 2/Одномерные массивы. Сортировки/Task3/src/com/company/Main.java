package com.company;

//3. Сортировка выбором. Дана последовательность чисел
//a1 <= a2 <=...<= an
//.Требуется переставить элементы так,
//чтобы они были расположены по убыванию. Для этого в массиве, начиная с первого, выбирается наибольший
//элемент и ставится на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта процедура
//повторяется. Написать алгоритм сортировки выбором.

public class Main {
    public static void main(String[] args) {
        int N = 20;
        int[] array = new int[N];
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 89 + 10);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int buf;
        int maxElement;
        int maxElementIndex = 0;
        for (int i = 0; i < N; i++) {
            maxElement = 0;
            for (int j = i; j < N; j++) {
                if (array[j] > maxElement) {
                    maxElementIndex = j;
                    maxElement = array[j];
                }
            }
            buf = array[maxElementIndex];
            array[maxElementIndex] = array[i];
            array[i] = buf;
        }
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < N; i++)
            System.out.print(array[i] + " ");
    }
}
