package com.company;

//1. Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.

public class Main {

    public static void main(String[] args) {
        String[] array = {"runeStoneSvarog", "glyphOfAard", "wolfSchoolSilverSword", "longswordFromSpikeroog", "dragonRoot", "kaedweniGambeson", "tyrNaLeah"};
        System.out.println("Массив из элементов в camelCase: ");
        for (String value : array) {
            System.out.print(value + ", ");
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length(); j++) {
                if (array[i].charAt(j) == array[i].toUpperCase().charAt(j) && j != 0 && array[i].charAt(j) != '_') { //если символ в верхнем регистре и не первый символ
                    array[i] = array[i].replace("" + array[i].charAt(j), "_" + array[i].toLowerCase().charAt(j)); //замена
                }
            }
        }
        System.out.println("Массив из элементов в snake_case: ");
        for (String s : array) {
            System.out.print(s + ", ");
        }
        System.out.println();
    }
}
