package com.company;

import com.company.cave.Cave;

import java.util.Scanner;

//Задача 4.
//Создать консольное приложение, удовлетворяющее следующим требованиям:
//• Приложение должно быть объектно-, а не процедурно-ориентированным.
//• Каждый класс должен иметь отражающее смысл название и информативный состав.
//• Наследование должно применяться только тогда, когда это имеет смысл.
//• При кодировании должны быть использованы соглашения об оформлении кода java code convention.
//• Классы должны быть грамотно разложены по пакетам.
//• Консольное меню должно быть минимальным.
//• Для хранения данных можно использовать файлы.
//Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
//дракона. Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и
//выбора сокровищ на заданную сумму.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cave dragonCave = new Cave();
        while (true) {
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Просмотр сокровищ");
        System.out.println("2. Выбор самого дорогого сокровища");
        System.out.println("3. Выбор сокровищ на заданную сумму");
        int key = scanner.nextInt();
            switch (key) {
                case 1:
                    dragonCave.print();
                    break;
                case 2:
                    dragonCave.theMostExpansive();
                    break;
                case 3:
                    dragonCave.forAGivenAmount();
                    break;
            }
        }
    }
}
