package com.company;

import java.util.Scanner;

//10. Дан целочисленный массив с количеством элементов п. Сжать массив, выбросив из него каждый второй
//элемент (освободившиеся элементы заполнить нулями). Примечание. Дополнительный массив не использовать.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            System.out.print(array[i] + ", ");
        }
        for (int i = 0; i < N; i++) {
            if (i % 2 == 1) {
                count++; //подсчет количества выброшенных элементов
            } else {
                array[i - count] = array[i];
            }
        }
        System.out.println();
        for (int i = count; i < N; i++) {
            array[i] = 0; //обнуление выброшенных элементов
        }
        System.out.println("Итоговый массив: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + ", ");
        }
    }


}
