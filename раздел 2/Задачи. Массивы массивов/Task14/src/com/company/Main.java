package com.company;

import java.util.Random;

//14. Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем в каждом столбце число
//единиц равно номеру столбца.

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int M = rand.nextInt(30 - 5) + 5;
        int N = rand.nextInt(30 - 5) + 5;
        int[][] array = new int[M][N];
        int count = 0; //количество 1, которые нужно поместить в столбец
        int count1 = 0; //подсчет 1, которые уже установлены в столбец
        boolean countJ = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                array[i][j] = 0;
            }
        }
        System.out.println();
        for (int j = 0; j < N; ) {
            if (!countJ) {
                count = j;
                countJ = true;
                count1 = 0;
            }
            for (int i = 0; i < M; i++) {
                if (rand.nextInt(11) == 5 && count != 0 && (array[i][j] == 0 || count1 >= M - 1)) //11 и 5 задают вероятность появления 1 в столбце
                {//если повезло с рандомом, есть еще 1, которые надо раскидать и элемент массива 0 либо мест в массиве уже нет
                    array[i][j] = 1;
                    count--;
                    count1++;
                }
            }
            if (count == 0) {
                countJ = false;
                j++;
            }
        }
        System.out.println("Матрица из 0 и 1: ");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
