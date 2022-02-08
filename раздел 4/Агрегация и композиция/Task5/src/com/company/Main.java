package com.company;

import java.util.Scanner;

//5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
//различного типа (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать
//возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.

public class Main {

    public static void showVouchersByCriterion(TravelVouchers travelVouchers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерий: ");
        System.out.println("1. Тип путевки");
        System.out.println("2. Длительность путевки");
        System.out.println("3. Тип транспорта");
        System.out.println("4. Количество приемов пищи");
        System.out.println("5. Максимальная цена путевки");
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                System.out.println("Введите тип путевки: ");
                String type = scanner.next();
                travelVouchers.printByType(type);
                break;
            case 2:
                System.out.println("Введите длительность путевки: ");
                int duration = scanner.nextInt();
                travelVouchers.printByDuration(duration);
                break;
            case 3:
                System.out.println("Введите тип транспорта: ");
                String transport = scanner.next();
                travelVouchers.printByTransport(transport);
                break;
            case 4:
                System.out.println("Введите количество приемов пищи: ");
                int food = scanner.nextInt();
                travelVouchers.printByFood(food);
                break;
            case 5:
                System.out.println("Введите максимальную цену путевки: ");
                int price = scanner.nextInt();
                travelVouchers.printByPrice(price);
                break;
        }
    }

    public static void sortVouchersByCriterion(TravelVouchers travelVouchers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите критерий: ");
        System.out.println("1. Тип путевки");
        System.out.println("2. Длительность путевки");
        System.out.println("3. Тип транспорта");
        System.out.println("4. Количество приемов пищи");
        System.out.println("5. Максимальная цена путевки");
        int key = scanner.nextInt();
        switch (key) {
            case 1:
                travelVouchers.sortByType();
                System.out.println("Путевки отсортированы по типу");
                break;
            case 2:
                travelVouchers.sortByDuration();
                System.out.println("Путевки отсортированы по длительности");
                break;
            case 3:
                travelVouchers.sortByTransport();
                System.out.println("Путевки отсортированы по типу транспорта");
                break;
            case 4:
                travelVouchers.sortByFood();
                System.out.println("Путевки отсортированы по количеству приемов пищи");
                break;
            case 5:
                travelVouchers.sortByPrice();
                System.out.println("Путевки отсортированы по стоимости");
                break;
        }
    }

    public static void main(String[] args) {
        TravelVoucher tVoucher1 = new TravelVoucher("отдых", 7, "Автомобиль", 3, 2000);
        TravelVoucher tVoucher2 = new TravelVoucher("экскурсии", 14, "Автобус", 2, 1000);
        TravelVoucher tVoucher3 = new TravelVoucher("лечение", 30, "Велосипед", 4, 3500);
        TravelVoucher tVoucher4 = new TravelVoucher("шопинг", 3, "Автомобиль", 2, 500);
        TravelVoucher tVoucher5 = new TravelVoucher("круиз", 30, "Круизное судно", 4, 5000);
        TravelVouchers travelVouchers = new TravelVouchers(tVoucher1);
        travelVouchers.addVoucher(tVoucher2);
        travelVouchers.addVoucher(tVoucher3);
        travelVouchers.addVoucher(tVoucher4);
        travelVouchers.addVoucher(tVoucher5);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Вывести все путевки");
            System.out.println("2. Вывести путевки по критерию");
            System.out.println("3. Отсортировать путевки по критерию");

            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    travelVouchers.print();
                    break;
                case 2:
                    showVouchersByCriterion(travelVouchers);
                    break;
                case 3:
                    sortVouchersByCriterion(travelVouchers);
                    break;
            }
        }
    }
}
