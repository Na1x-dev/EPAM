package com.company;

//9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские
//буквы.

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку для поиска слово с наибольшей длиной: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Строка: " + str);
        int countUpperCase = 0;
        int countLowerCase = 0;
        for (int i = 0; i < str.length(); i++) {
            String strBuf = "" + str.charAt(i);
            if (strBuf.matches("[A-Z]")) {
                countUpperCase++;
            } else if (strBuf.matches("[a-z]")) {
                countLowerCase++;
            }
        }
        System.out.println("Количество строчных букв: " + countLowerCase + " Количество прописных букв: " + countUpperCase);
    }
}
