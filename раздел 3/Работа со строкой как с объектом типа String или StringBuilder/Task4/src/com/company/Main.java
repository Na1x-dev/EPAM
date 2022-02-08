package com.company;

//4. С помощью функции копирования и операции конкатенации составить из частей слова “информатика” слово “торт”.

public class Main {

    public static void main(String[] args) {
        String str = "информатика";
        StringBuilder strBuilder1 = new StringBuilder(str);
        StringBuilder strBuilder2 = new StringBuilder();
        strBuilder2.insert(0, strBuilder1.charAt(7));
        strBuilder2.insert(1, strBuilder1.charAt(3));
        strBuilder2.insert(2, strBuilder1.charAt(4));
        strBuilder2.insert(3, strBuilder1.charAt(7));
        System.out.println(strBuilder1);
        System.out.println(strBuilder2);
    }
}
