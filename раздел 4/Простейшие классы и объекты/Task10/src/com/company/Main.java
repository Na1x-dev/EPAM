package com.company;

import java.util.Scanner;

//10. Создать класс Airline, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Airline, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
//Найти и вывести:
//a) список рейсов для заданного пункта назначения;
//b) список рейсов для заданного дня недели;
//c) список рейсов для заданного дня недели, время вылета для которых больше заданного.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Airlines airlines = new Airlines();
        Airline c1 = new Airline();
        Airline c2 = new Airline("Рим", 235, "Ту-134", "23:15", new String[]{"понедельник", "вторник", "воскресенье"});
        Airline c3 = new Airline("Рим", 137, "Ту-154", "16:14", new String[]{"понедельник", "вторник", "четверг", "пятница", "воскресенье"});
        Airline c4 = new Airline("Варшава", 346, "Ил-96", "23:34", new String[]{"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"});
        airlines.addAirline(c1);
        airlines.addAirline(c2);
        airlines.addAirline(c3);
        airlines.addAirline(c4);

        while (true) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Добавить новую авиакомпанию");
            System.out.println("2. Вывести список рейсов для заданного пункта назначения");
            System.out.println("3. Вывести список рейсов для заданного дня недели");
            System.out.println("4. Вывести список рейсов для заданного дня недели, время вылета для которых больше заданного");
            System.out.println("5. Вывести список всех рейсов");
            int key = scanner.nextInt();

            switch (key) {
                case 1:
                    airlines.addAirline(Airline.setAirline());
                    break;
                case 2:
                    System.out.println("Введите пункт назначения: ");
                    airlines.flightOfDestination(scanner.next());
                    break;
                case 3:
                    System.out.println("Введите день недели: ");
                    airlines.forDayOfWeek(scanner.next());
                    break;
                case 4:
                    System.out.println("Введите день недели: ");
                    String day = scanner.next();
                    System.out.println("Введите время (**:**): ");
                    String time = scanner.next();
                    airlines.forDayAndTime(day, time);
                    break;
                case 5:
                    airlines.print();
                    break;
                default:
                    System.out.println("Такого пункта нет");
                    break;

            }
        }
    }
}
