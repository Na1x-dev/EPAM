package com.company;

import java.util.Scanner;

//1. Напишите программу, где пользователь вводит любое целое положительное число. А программа суммирует
//все числа от 1 до введенного пользователем числа.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, sum = 0;
        System.out.println("Введите любое целое положительное число: ");
        A = scanner.nextInt();
        for (int i = 1; i <= A; i++) {
            sum += i;
        }
        System.out.println("сумма чисел от 1 до " + A + ": " + sum);
    }
}
