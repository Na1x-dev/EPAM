package com.company;

//5. Подсчитать, сколько раз среди символов заданной строки встречается буква “а”.

public class Main {

    public static void main(String[] args) {
        String str = "This function returns the target text, or a blank text string if the target is not a text string.";
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Строка: " + strBuilder);
        int count = 0;
        for (int i = 0; i < strBuilder.length(); i++) {
            if (strBuilder.charAt(i) == 'a') {
                count++;
            }
        }
        System.out.println("Буква а встречается " + count + " раз(а) в строке.");
    }
}
