package com.company;

import java.util.Scanner;

//3. Проверить, является ли заданное слово палиндромом.

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите слово, чтобы узнать, является ли оно палиндромом: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder strBuilder = new StringBuilder(str);
        if (strBuilder.toString().equalsIgnoreCase(strBuilder.reverse().toString())) {
            System.out.println("Слово " + strBuilder + " является палиндромом.");
        } else {
            System.out.println("Слово " + str + " не является палиндромом.");
        }
    }
}
