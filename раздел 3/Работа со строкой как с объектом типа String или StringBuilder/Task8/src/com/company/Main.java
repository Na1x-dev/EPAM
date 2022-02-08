package com.company;

import java.util.Scanner;

//8. Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран. Случай, когда самых
//длинных слов может быть несколько, не обрабатывать.

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку для поиска слово с наибольшей длиной: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Строка: " + strBuilder);
        int maxWordLength = 0;
        int maxWordLengthIndex = 0;
        int count = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            count++;
            if (strBuilder.charAt(i) == ' ') {
                if (maxWordLength < count) {
                    maxWordLength = count;
                    maxWordLengthIndex = i;
                }
                count = 0;
            }
        }
        System.out.println("Слово с максимальной длиной: " + strBuilder.substring(maxWordLengthIndex - maxWordLength, maxWordLengthIndex));
    }
}
