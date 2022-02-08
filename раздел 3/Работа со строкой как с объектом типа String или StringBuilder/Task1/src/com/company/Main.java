package com.company;

import java.util.ArrayList;

//1. Дан текст (строка). Найдите наибольшее количество подряд идущих пробелов в нем.

public class Main {

    public static void main(String[] args) {
        String str = "   the               program.    jjhhhhkd       df  ";
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Строка: " + str);
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            char ch = strBuilder.charAt(i);
            if (ch == ' ') {
                count++;
            } else {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            }
        }
        System.out.println("Максимальное количество подряд идущих пробелов: " + maxCount);
    }
}
