package com.company;

import java.util.ArrayList;

public class Books {
    private ArrayList<Book> books;

    Books() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void print() {
        for (Book book : books) {
            book.print();
        }
    }

   public void authorsBooks(String author) {
       for (Book book : books) {
           if (book.getAuthor().equals(author)) {
               book.print();
           }
       }
   }

    public void publishingBooks(String publishing) {
        for (Book book : books) {
            if (book.getPublishing().equals(publishing)) {
                book.print();
            }
        }
    }

    public void afterYear(int year) {
        for (Book book : books) {
            if (book.getYear() >= year) {
                book.print();
            }
        }
    }
}