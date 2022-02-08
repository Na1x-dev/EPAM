package com.company;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

public class Book {
    private long id;
    private String name;
    private String author;
    private String publishing; //отчество
    private int year;
    private int pages;
    private int price;
    private String bindingType;
    private static int ID;

    Book(String name, String author, String publishing, int year, int pages, int price, String bindingType) {
        this.id = ID++;
        this.name = name;
        this.author = author;
        this.publishing = publishing;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.bindingType = bindingType;
    }

    Book() {
        this.id = ID++;
        this.name = "О дивный новый мир";
        this.author = "Олдос Хаксли";
        this.publishing = "Chatto & Windus";
        this.year = 1932;
        this.pages = 180;
        this.price = 10;
        this.bindingType = "мягкий";
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishing() {
        return publishing;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public int getPrice() {
        return price;
    }

    public String getBindingType() {
        return bindingType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", year=" + year +
                ", pages=" + pages +
                ", price=" + price +
                ", bindingType='" + bindingType + '\'' +
                '}';
    }

    public void print() {
        System.out.println(
                "id: " + id +
                        ", Название книги: " + name +
                        ", Автор: " + author +
                        ", Издательство: " + publishing +
                        ", Год издания: " + year +
                        ", Количество страниц: " + pages +
                        ", Цена: " + price +
                        ", Тип переплета: " + bindingType);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public static Book setBook() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        Book book = new Book("", "", "", 0, 0, 0, "");
        System.out.print("Название книги: ");
        book.name = scanner.nextLine();
        System.out.print("Автор книги: ");
        book.author = scanner.nextLine();
        System.out.print("Издательство: ");
        book.publishing = scanner.nextLine();
        System.out.print("Год выпуска: ");
        book.year = scanner.nextInt();
        System.out.print("Количество страниц: ");
        book.pages = scanner.nextInt();
        System.out.print("Цена: ");
        book.price = scanner.nextInt();
        System.out.print("Тип переплета: ");
        book.bindingType = scanner1.nextLine();
        return book;
    }
}