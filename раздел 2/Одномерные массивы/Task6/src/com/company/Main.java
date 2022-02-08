package com.company;

import java.util.Scanner;

//6. Задана последовательность N вещественных чисел. Вычислить сумму чисел, порядковые номера которых
//являются простыми числами.

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            System.out.print(array[i] + "[" + i + "], ");
            if (isSimpleNumber(i)) {
                sum = sum + array[i];
            }
        }
        System.out.println();
        System.out.println("Сумма элементов с простым индексом: " + sum);
    }

    static public boolean isSimpleNumber(int number) {
        if (number == 0 || number == 1)
             return false;
        for (int j = 2; j < number; j++) {
            if (number % j == 0)
                return false;
        }
        return true;
    }
}
