package com.company;

//11. Матрицу 10x20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера строк, в
//которых число 5 встречается три и более раз.

public class Main {

    public static void main(String[] args) {
        boolean isLineMatch; // нужна для того, чтобы номера строк не повторялись при выводе в консоль
        int[][] array = new int[10][20];
        int countOfFives; // счетчик пятерок в строке
        System.out.println("Массив: ");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                array[i][j] = (int) (Math.random() * 15);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Номера строк с 3-мя и более числами 5 в массиве: ");
        for (int i = 0; i < 10; i++) {
            countOfFives = 0;
            isLineMatch = false;
            for (int j = 0; j < 20; j++) {
                if (array[i][j] == 5) {
                    countOfFives++;
                    if (countOfFives >= 3 && !isLineMatch) {
                        System.out.print(i + ", ");
                        isLineMatch = true;
                    }
                }
            }
        }
        System.out.println();
    }
}
