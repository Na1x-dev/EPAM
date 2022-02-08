package com.company;

//15. Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
//последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.

public class Main {

    public static void main(String[] args) {
        System.out.println("Натуральные числа, которые образуют строго возрастающую последовательность: ");
        for (int i = 10; i < 1234567890; i++) {
            if (isAscendingSequence(arrayFromNumber(i))) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }

    public static boolean isAscendingSequence(int[] array) {
        boolean res = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != 1) {
                res = false;
                break;
            }
        }
        return res;
    }

    public static int numberLength(int N) {
        int length = 0;
        while (N != 0) {
            N = N / 10;
            length++;
        }
        return length;
    }

    public static int[] arrayFromNumber(int N) {
        int[] array = new int[numberLength(N)];
        int i = numberLength(N) - 1;
        while (N != 0) {
            array[i] = N % 10;
            N = N / 10;
            i--;
        }
        return array;
    }
}
