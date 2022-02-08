package com.company;

import java.util.ArrayList;

//5. Сортировка вставками. Дана последовательность чисел
//n a ,a , ,a 1 2 
//. Требуется переставить числа в порядке
//возрастания. Делается это следующим образом. Пусть
//a a ai
//, , , 1 2  - упорядоченная последовательность, т. е.
//a1  a2  an
//. Берется следующее число
//i+1 a
//и вставляется в последовательность так, чтобы новая
//последовательность была тоже возрастающей. Процесс производится до тех пор, пока все элементы от i +1 до n
//не будут перебраны. Примечание. Место помещения очередного элемента в отсортированную часть производить
//с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.

public class Main {

    public static void main(String[] args) {
        int N = 20;
        int[] array = new int[N];
        ArrayList<Integer> sortArray = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            array[i] = (int) (Math.random() * 89 + 10);
            sortArray.add(array[i]);
        }
        System.out.println();
        System.out.println(sortArray);
        sortWithBinSearch(sortArray);
        System.out.println(sortArray);
        System.out.println();
    }

    public static int binarySearch(int number, ArrayList<Integer> array, int sortSize) {
        int newI = 0;
        boolean isReady = false; // false пока не отсортируется
        int left = 0;
        int right = sortSize - 1;
        int mid = (left + right) / 2;
        do {
            if (number >= array.get(mid) && number >= array.get(mid + 1) && mid < sortSize - 2) {
                left = mid;
            } else if (number < array.get(mid) && number < array.get(mid + 1)) {
                right = mid;
            } else if (number >= array.get(mid) && number < array.get(mid + 1)) {
                newI = mid + 1;
                isReady = true;
            } else if (number >= array.get(mid + 1) && mid + 2 == sortSize) {
                newI = sortSize + 1;
                isReady = true;
            }
            mid = (left + right) / 2;
        } while (!isReady); 

        return newI;
    }

    public static ArrayList sortWithBinSearch(ArrayList<Integer> array) {
        int min = 100;
        int minI = 0;
        for (int i = 0; i < array.size(); i++) {
            if (min > array.get(i)) {
                min = array.get(i);
                minI = i;
            }
        }
        array.set(minI, array.get(0));
        array.set(0, min);
        for (int i = 2; i < array.size(); i++) {
            int newI = binarySearch(array.get(i), array, i);
            array.add(newI, array.get(i));
            array.remove(i + 1);
        }
        return array;
    }
}
