package com.company;

//4. Даны действительные числа а1 ,а2 ,..., аn . Поменять местами наибольший и наименьший элементы.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        int min = 100, max = -100;
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println("Самый большой элемент: " + max + ", самый маленький элемент: " + min);
    }
}
