package com.company;

//9. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число. Если таких
//чисел несколько, то определить наименьшее из них.

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int maxCount = 0;
        int min = 100;
        int[] array = new int[N];
        int[] counters = new int[N];
        int[] newArray = new int[N];
        boolean isInArray = false;
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 10);
            newArray[i] = -1;
            System.out.print(array[i] + ", ");
        }
        for (int i = 0; i < N; i++) { //проходим по массиву и смотрим, какое число чаще встречается
            for (int j = 0; j < N; j++) {
                if (array[i] == array[j]) {
                    counters[i]++;
                }
                if (counters[i] > maxCount)
                    maxCount = counters[i];
            }
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (counters[i] == maxCount && counters[i] == counters[j] && array[i] != array[j] && min > array[i]) {
                    //ищем минимальное частовстречающееся число
                    min = array[i];
                }
            }
        }
        for (int i = 0; i < N; i++) { // записываем все частовстречающиеся числа (если их несколько) в массив
            isInArray = false; // для записи в массив без повторений
            if (counters[i] == maxCount) {
                for (int j = 0; j < N; j++) {
                    if (newArray[j] == array[i] && !isInArray) {
                        isInArray = true;
                    }
                }
                if (!isInArray)
                    newArray[i] = array[i];
            }
        }
        System.out.print("Массив из наиболее частоповторяющихся чисел: ");
        for (int i = 0; i < N; i++) {
            if (newArray[i] >= 0)
                System.out.print(newArray[i] + ", ");
        }
        System.out.println();
        if (min != 100)
            System.out.println("Минимальное из наиболее частоповторяющихся чисел: " + min);
    }
}
