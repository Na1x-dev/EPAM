package com.company;

//6. Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.

public class Main {

    public static void main(String[] args) {
        System.out.println(" N   SYM  OCT  HEX\n");
        for (int i = 33; i < 256; i++) {
            char sym = (char) i;
            String tempHex = Integer.toHexString(i);
            String tempOct = Integer.toOctalString(i);
            System.out.printf("%03d %3s %5s %4s%n", i, sym, tempOct, tempHex);
        }
    }
}
