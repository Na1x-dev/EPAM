package com.company;
import java.util.Scanner;

//5. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
//заданному е.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите некоторое число е: ");
        double e = scanner.nextDouble();
        double sumAn = 0, An;
        int i = 0;
        boolean cycle = false;
        do {
            An = (((double) 1 / Math.pow(2, i)) + ((double) 1 / Math.pow(3, i)));
            if (e < An) {
                sumAn = sumAn + An;
                i++;
            } else
                cycle = true;
        } while (!cycle);
        System.out.println("Сумма чисел ряда меньших, чем " + e + ": " + sumAn);
    }
}
