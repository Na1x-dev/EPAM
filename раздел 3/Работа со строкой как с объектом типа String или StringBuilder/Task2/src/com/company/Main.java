package com.company;

//2. В строке вставить после каждого символа 'a' символ 'b'.

public class Main {

    public static void main(String[] args) {
        String str = "This function returns the target text, or a blank text string if the target is not a text string.";
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Изначальная строка: " + strBuilder);
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == 'a') {
                strBuilder.insert(i + 1, "b");
            }
        }
        System.out.println("Итоговая строка: " + strBuilder);
    }
}
