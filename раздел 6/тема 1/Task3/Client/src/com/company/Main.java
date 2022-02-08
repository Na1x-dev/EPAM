package com.company;

import java.util.Scanner;

//Задание 3: создайте клиент-серверное приложение “Архив”.
//Общие требования к заданию:
//• В архиве хранятся Дела (например, студентов). Архив находится на сервере.
//• Клиент, в зависимости от прав, может запросить дело на просмотр, внести в
//него изменения, или создать новое дело.
//Требования к коду лабораторной работы:
//• Для реализации сетевого соединения используйте сокеты.
//• Формат хранения данных на сервере – xml-файлы.

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public static int scanIntIndex(int firstBorder, int secondBorder){
        Scanner scanner = new Scanner(System.in);
        int index;
        do {
            System.out.println("Введите номер элемента или введите 0 для перехода в предыдущее меню");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            index = scanner.nextInt();
        } while (index < firstBorder || index >= secondBorder);
        return index;
    }
}



