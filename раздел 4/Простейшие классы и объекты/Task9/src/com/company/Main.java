package com.company;

import java.util.Scanner;

//9. Создать класс Book, спецификация которого приведена ниже. Определить конструкторы, set- и get- методы и
//метод toString(). Создать второй класс, агрегирующий массив типа Book, с подходящими конструкторами и
//методами. Задать критерии выбора данных и вывести эти данные на консоль.
//Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
//Найти и вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Books books = new Books();
        Book c1 = new Book();
        Book c2 = new Book("1984", "Джордж Оруэл", "Secker and Warburg", 1949, 270, 15,"твердый");
        Book c3 = new Book("451 градус по Фаренгейту", "Рэй Брэдбери", "Ballantine Books", 1953, 256, 13, "мягкий");
        Book c4 = new Book("Скотный двор", "Джордж Оруэл", "Harvill Secker", 1945, 86, 8, "мягкий");
        books.addBook(c1);
        books.addBook(c2);
        books.addBook(c3);
        books.addBook(c4);
        while (true) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Вывести список книг заданного автора");
            System.out.println("3. Вывести список книг, выпущеных заданным издательством");
            System.out.println("4. Вывести список книг, выпущеных после заданного года");
            System.out.println("5. Вывести список книг");
            int key = scanner1.nextInt();
            switch (key){
                case 1:
                    books.addBook(Book.setBook());
                    break;
                case 2:
                    System.out.println("Введите автора: ");
                    books.authorsBooks(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Введите издательство: ");
                    books.publishingBooks(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Введите год: ");
                    books.afterYear(scanner.nextInt());
                    break;
                case 5:
                    books.print();
                    break;
                default:
                    System.out.println("Такого пункта нет");
                    break;
            }
        }
    }
}
