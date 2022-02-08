package com.company;

//5. Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы.
//Крайние пробелы в строке удалить.

public class Main {

    public static void main(String[] args) {
        String str = "     this         sentence         was         created          to      test    a   working      (not)        function     of     the     program.   ";
        System.out.println("Начальная строка: \n" + str);
        String regex = "\\s+";
        String[] splitStr = str.split(regex);
        str = "";
        for (String s : splitStr) {
            str = str + " " + s;
        }
        str = str.trim();
        System.out.println("Конечная строка: \n" + str);
    }
}
