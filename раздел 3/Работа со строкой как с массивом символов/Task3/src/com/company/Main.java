package com.company;

//3. В строке найти количество цифр.

public class Main {

    public static void main(String[] args) {
        String str = "a093i4kfrgdf/.g,;34p43456565k9s2";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String find = "" + str.charAt(i);
            if (find.matches("\\d")) {
                count++;
            }
        }
        System.out.println("Количество цифр в строке " + str + ": " + count);
    }
}
