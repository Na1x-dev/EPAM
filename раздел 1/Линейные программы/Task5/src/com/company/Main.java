package com.company;

import java.util.Scanner;

//5. Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести
//данное значение длительности в часах, минутах и секундах в следующей форме:
//ННч ММмин SSc.

public class Main {

    public static void main(String[] args) {
        int a, sec, min, hour;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите время в секундах: ");
        a = scanner.nextInt();
        hour = a / 3600;
        a = a % 3600;
        min = a / 60;
        a = a % 60;
        sec = a;
        System.out.println(hour + ":" + min + ":" + sec);
    }
}
