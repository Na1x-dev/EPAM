package com.company;

//2. Замените в строке все вхождения 'word' на 'letter'.

public class Main {

    public static void main(String[] args) {
        String str = "This is the word, and that is the word, there is the wordword";
        System.out.println("Начальная строка: " + str);
        String newStr = str.replace("word", "letter");
        System.out.println("Конечная строка: " + newStr);
        System.out.println();
    }
}
