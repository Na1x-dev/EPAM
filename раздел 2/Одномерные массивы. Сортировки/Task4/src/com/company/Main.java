package com.company;

//4. Сортировка обменами. Дана последовательность чисел
//a1 <= a2 <=...<= an
//.Требуется переставить числа в
//порядке возрастания. Так продолжается до тех пор, пока все элементы не станут расположены в порядке возрастания.
//Составить алгоритм сортировки, подсчитывая при этом количества перестановок.

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
        int count = 0;
        int buf;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    buf = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = buf;
                    count++;
                }
            }
        }
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("Количество перестановок: " + count);
    }
}
