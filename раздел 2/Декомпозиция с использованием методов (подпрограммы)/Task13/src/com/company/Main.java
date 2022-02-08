package com.company;

import java.util.Scanner;

//13. Два простых числа называются «близнецами», если они отличаются друг от друга на 2 (например, 41 и 43).
//Найти и напечатать все пары «близнецов» из отрезка [n,2n], где n - заданное натуральное число больше 2. Для
//решения задачи использовать декомпозицию.

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите число n, чтобы задать длину интервала [n, 2n]: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TwinPrimeNumbers(n);
        System.out.println();
    }

    public static boolean isPrimeNumber(int num) {
        int var = 2;
        boolean isntPrimeNumber = true;
        if (num > 1) {
            while (num != var) {
                if (num % var == 0)
                    isntPrimeNumber = false;
                var++;
            }
        }
        return isntPrimeNumber;
    }

    public static void TwinPrimeNumbers(int n) {
        System.out.println("Все простые числа близнецы для отрезка [" + n + ", " + (n * 2) + "]: ");
        for (int i = n; i <= n * 2 - 2; i++) {
            if (isPrimeNumber(i) && isPrimeNumber(i + 2)) {
                System.out.print(i + " и " + (i + 2) + ", ");
            }
        }
    }
}
