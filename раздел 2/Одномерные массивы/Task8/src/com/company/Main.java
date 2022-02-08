package com.company;

import java.util.Scanner;

//8. Дана последовательность целых чисел a1, a2, ..., an. Образовать новую последовательность, выбросив из
//исходной те члены, которые равны min(a1, a2, ..., an). 

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        int min = 100;
        int countOfMin = 0; //количество элементов, которые равны минимальному элементу
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            System.out.print(array[i] + ", ");
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = 0; i < N; i++) {
            if (array[i] == min)
                countOfMin++;
        }
        int[] newArray = new int[N - countOfMin];
        int i = 0;
        int j = 0;
        while (j < N) {
            if (array[j] != min) {
                newArray[i] = array[j];
                i++;
            }
            j++;
        }
        System.out.println();
        System.out.print("Новый массив: ");
        for (i = 0; i < N - countOfMin; i++) {
            System.out.print(newArray[i] + ", ");
        }
        System.out.println();
        System.out.println("min: " + min);
    }
}
