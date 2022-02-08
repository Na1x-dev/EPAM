package com.company;

//6. Из заданной строки получить новую, повторив каждый символ дважды.

public class Main {

    public static void main(String[] args) {
        String str = "This function returns the target text, or a blank text string if the target is not a text string.";
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Строка: " + strBuilder);
        StringBuilder strBuilder1 = new StringBuilder();
        strBuilder1.ensureCapacity(str.length() * 2);
        for (int i = 0; i < strBuilder.length(); i++) {
            strBuilder1.insert(i + i, strBuilder.charAt(i));
            strBuilder1.insert(i + i + 1, strBuilder.charAt(i));
        }
        System.out.println("Новая строка: " + strBuilder1);
    }
}
