package com.company;

import java.util.Scanner;

//4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки
//счета. Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по
//всем счетам, имеющим положительный и отрицательный балансы отдельно.

public class Main {

    public static Bill choice(Bills bills) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите способ поиска: ");
        System.out.println("1. По порядковому номеру");
        System.out.println("2. По номеру счета");
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                System.out.println("Введите индекс счета от 1 до " + bills.getSize());
                int index = scanner.nextInt();
                return bills.find(index - 1);
            case 2:
                System.out.println("Введите номер счета");
                long number = scanner.nextLong();
                return bills.find(number);
        }
        return null;
    }

    public static void main(String[] args) {
        Client client = new Client(new Bill(0, 4794542759826685L));

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Добавить новый счет");
            System.out.println("2. Заблокировать счет");
            System.out.println("3. Разблокировать счет");
            System.out.println("4. Отсортировать счета");
            System.out.println("5. Вывести все счета в консоль");
            System.out.println("6. Вывести один счет в консоль");
            System.out.println("7. Вывести общую сумму по счетам в консоль");
            System.out.println("8. Вывести суммы положительных и отрицательных счетов");
            System.out.println("9. Добавить денег на счет");
            System.out.println("0. Потратить деньги счета");

            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    client.addBill();
                    break;
                case 2:
                    choice(client.bills).block();
                    break;
                case 3:
                    choice(client.bills).unblock();
                    break;
                case 4:
                    client.bills.sort();
                    break;
                case 5:
                    client.bills.printBills();
                    break;
                case 6:
                    choice(client.bills).print();
                    break;
                case 7:
                    client.bills.printSum();
                    break;
                case 8:
                    client.bills.printTwoSums();
                    break;
                case 9:
                    choice(client.bills).addMoney();
                    break;
                case 0:
                    choice(client.bills).spendMoney();
                    break;
            }
        }
    }
}
