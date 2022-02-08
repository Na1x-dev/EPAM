package com.company;

import java.util.Scanner;

public class Interface {

    private Payment payment;

    Interface(Payment payment) {
        this.payment = payment;
    }

    public void mainMenu() { //главное меню
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        while (key != 4) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Показать содержимое корзины");
            System.out.println("2. Выбрать продукты");
            System.out.println("3. Оплатить");
            System.out.println("4. Выйти");
            key = scanner.nextInt();
            switch (key) {
                case 1://показать содержимое корзины
                    payment.print();
                    break;
                case 2: //выбрать продукты
                    productMenu(); //вызвать меню с продуктами
                    payment.checkBasket(); //чистка корзины от мусора
                    break;
                case 3: //оплатить
                    payment.pay();
                    break;
            }
        }
    }

    public void productMenu() { //меню выбора продукта
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        while (key != 7) {
            System.out.println("Список товаров магазина:");
            System.out.println("Выберите товар, который хотите добавить: ");
            System.out.println("1. Картофель");
            System.out.println("2. Мед");
            System.out.println("3. Васаби");
            System.out.println("4. Нитки");
            System.out.println("5. Хлеб");
            System.out.println("6. Вода");
            System.out.println("7. Назад");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    payment.addProduct("Картофель");
                    break;
                case 2:
                    payment.addProduct("Мед");
                    break;
                case 3:
                    payment.addProduct("Васаби");
                    break;
                case 4:
                    payment.addProduct("Нитки");
                    break;
                case 5:
                    payment.addProduct("Хлеб");
                    break;
                case 6:
                    payment.addProduct("Вода");
                    break;
            }
        }
    }
}
