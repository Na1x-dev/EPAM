package com.company;

//Задача 2.
//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в фермерский магазин Джереми Кларксона!");
        InStock inStock = new InStock(); //создание объекта склада
        Payment payment = new Payment(inStock); //создание объекта покупки
        Interface anInterface = new Interface(payment); //создание объекта интерфейса
        anInterface.mainMenu(); //вызов главного меню
    }
}
