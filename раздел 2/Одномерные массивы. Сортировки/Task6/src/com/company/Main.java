package com.company;

//6. Сортировка Шелла. Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
//Делается это следующим образом: сравниваются два соседних элемента
//ai и ai+1
//. Если
//ai  ai+1
//, то продвигаются
//на один элемент вперед. Если
//ai  ai+1
//, то производится перестановка и сдвигаются на один элемент назад.
//Составить алгоритм этой сортировки.

import java.util.ArrayList;

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
        int buf, j;
        for (int step = N / 2; step > 0; step /= 2)
            for (int i = step; i < N; i++) {
                buf = array[i];
                for (j = i; j >= step; j -= step) {
                    if (buf < array[j - step])
                        array[j] = array[j - step];
                    else
                        break;
                }
                array[j] = buf;
            }
        System.out.println("Отсортированный массив: ");
        for (int i = 0; i < N; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}
