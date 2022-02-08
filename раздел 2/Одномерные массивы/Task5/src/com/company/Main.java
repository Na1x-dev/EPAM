package com.company;

//5. Даны целые числа а1 ,а2 ,..., аn . Вывести на печать только те числа, для которых аi > i.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        System.out.print("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.print("Числа массива, для которых справедливо аi > i: ");
        for (int i = 0; i < N; i++) {
            if (array[i] > i)
                System.out.print(array[i] + ", ");
        }
    }
}
