package com.company;
import java.util.Scanner;

//7. Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
//m и n вводятся с клавиатуры.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число m: ");
        int m = scanner.nextInt();
        System.out.println("Введите число n: ");
        int n = scanner.nextInt();
        for (int i = m; i <= n; i++) {
            System.out.print("Делители для числа " + i + ": ");
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    System.out.print(j + ", ");
            }
            System.out.println();
        }
    }
}
