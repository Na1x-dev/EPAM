package com.company;

import java.util.Scanner;

//Задача 3.
//Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
//выходных и праздничных днях.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calender calender = new Calender();
        while (true) {
            calender.print();
            System.out.println();
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Месяц назад");
            System.out.println("2. Месяц вперед");
            System.out.println("3. Ввести месяц и год");
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    calender.monthAgo();
                    break;
                case 2:
                    calender.monthAhead();
                    break;
                case 3:
                    calender.findMonth();
                    break;
            }
        }
    }
}
