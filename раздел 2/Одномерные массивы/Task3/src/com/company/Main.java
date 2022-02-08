package com.company;

//3. Дан массив действительных чисел, размерность которого N. Подсчитать, сколько в нем отрицательных,
//положительных и нулевых элементов.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int N = sc.nextInt();
        int[] array = new int[N];
        int countPlus = 0, countZero = 0, countMinus = 0;
        System.out.println("Массив: ");
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 200 - 100);
            if (array[i] == 0)
                countZero++;
            else if (array[i] > 0)
                countPlus++;
            else if (array[i] < 0)
                countMinus++;
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println("Количество положительных элементов: " + countPlus + ", количество нулевых элементов: "
                + countZero + ", количество отрицательных элементов: " + countMinus);
    }
}
