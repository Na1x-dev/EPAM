package com.company;

//7. Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено "abc cde
//def", то должно быть выведено "abcdef".

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите строку для удаления из нее повторяющихся символов и пробелов: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println("Строка: " + strBuilder);
        StringBuilder strBuilder1 = new StringBuilder();
        boolean add;
        for (int i = 0; i < strBuilder.length(); i++) {
            add = true;
            for (int j = 0; j < strBuilder1.length(); j++) {
                if (strBuilder.charAt(i) == strBuilder1.charAt(j)) {
                    add = false;
                }
            }

            if (add && strBuilder.charAt(i) != ' ') {
                strBuilder1.insert(0, strBuilder.charAt(i));
            }
        }
        strBuilder1.reverse();
        System.out.println("Строка без повторяющихся символов и пробелов: " + strBuilder1);
    }
}
