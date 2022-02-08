package com.company;

import java.util.Scanner;

//8. Создать класс Customer, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы
//и метод toString(). Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами
//и методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
//Найти и вывести:
//a) список покупателей в алфавитном порядке;
//b) список покупателей, у которых номер кредитной карточки находится в заданном интервале

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customers customers = new Customers();
        Customer c1 = new Customer("Иван", "Потворов", "Валерьевич", "г. Иваново, ул. Иванова, д. 77, кв. 22", 1123655987230194l, 129835);
        Customer c2 = new Customer("Никита", "Троцюк", "Игоревич", "г. Иваново, ул. Иванова, д. 77, кв. 22", 9402128766237653l, 979834);
        Customer c3 = new Customer("Александр", "Данилюк", "Игоревич", "г. Иваново, ул. Иванова, д. 77, кв. 22", 2376528364761293l, 123764);
        Customer c4 = new Customer("Александр", "Рахта", "Владимирович", "г. Иваново, ул. Иванова, д. 77, кв. 22", 2637461687628173l, 345290);
        Customer c5 = new Customer("Дмитрий", "Афанасьев", "Александрович", "г. Иваново, ул. Иванова, д. 77, кв. 22", 9871868746972687l, 455284);
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        customers.addCustomer(c3);
        customers.addCustomer(c4);
        customers.addCustomer(c5);


        while (true) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Добавить нового покупателя");
            System.out.println("2. Вывести список покупателей в алфавитном порядке");
            System.out.println("3. Вывести список покупателей, у которых номер кредитной карты находится в заданном интервале");
            int key = scanner.nextInt();

            switch (key){
                case 1:
                    customers.addCustomer(Customer.setCustomer(scanner));
                    break;
                case 2:
                    customers.sortByName();
                    customers.print();
                    break;
                case 3:
                    System.out.println("Введите минимальный номер карты: ");
                    int a = scanner.nextInt();
                    System.out.println("Введите максимальный номер карты: ");
                    int b = scanner.nextInt();
                    customers.printIfCardIn(a, b);
                    break;
                default:
                    System.out.println("Такого пункта нет");
                    break;

            }
        }
    }
}
