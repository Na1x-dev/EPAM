package com.company;

//4. В строке найти количество чисел.

public class Main {

    public static void main(String[] args) {
        String str = "a093i4 kfrg 3 df/.g,;34p43df4 55d46h g6565k9s2";
        int count = 0;
        String[] splitedStrings = str.split("\\D");
        for (String s : splitedStrings) {
            if (!s.equals("")) {
                count++;
            }
        }
        System.out.println();
        System.out.println("Количество чисел в строке " + str + ": " + count);
    }
}
