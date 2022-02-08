package com.company;

import java.util.Scanner;

//5. Вычислить значение функции:

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите x: ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        double y;
        if (x <= 3) {
            y = Math.pow(x, 2) - 3 * x + 9;
        } else {
            y = 1 / (Math.pow(x, 3) + 6);
        }
        System.out.println("Значение функции: " + y);
    }
}
