package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Library {
    private static String BOOKS_PATH = "books.txt";
    private List<Book> books = new ArrayList<>();

    Library() {
        initialiseBooksList();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksInFile();
        System.out.println("Книга успешно добавлена");
    }

    public void deleteBook(Book book) {
        books.remove(book);
        saveBooksInFile();
        System.out.println("Книга успешно удалена");
    }

    public List<Book> findBooks(String name) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(name)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    private List<String> getBooksStringList() {
        StringBuilder booksString = new StringBuilder();
        String[] booksStringArray;
        List<String> booksStringList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(BOOKS_PATH)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            int i = -1;
            while ((i = in.read()) != -1) {
                booksString.append((char) i);
            }
            booksStringArray = booksString.toString().split("\n");
            booksStringList = Arrays.asList(booksStringArray);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return booksStringList;
    }

    private void initialiseBooksList() {
        List<String> booksStringList = getBooksStringList();
        List<Book> books = new ArrayList<>();
        Pattern bookNamePattern = Pattern.compile("bookName: .+?;");
        Pattern bookAuthorPattern = Pattern.compile("bookAuthor: .+?;");
        Pattern bookPublishingPattern = Pattern.compile("bookPublishing: .+?;");
        Pattern yearOfPublishingPattern = Pattern.compile("yearOfPublishing: .+?;");
        Pattern bookTypePattern = Pattern.compile("bookType: .+?;");
        for (int i = 0; i < booksStringList.size(); i++) {
            Book book = new Book();
            Matcher bookNameMatcher = bookNamePattern.matcher(booksStringList.get(i));
            Matcher bookAuthorMatcher = bookAuthorPattern.matcher(booksStringList.get(i));
            Matcher bookPublishingMatcher = bookPublishingPattern.matcher(booksStringList.get(i));
            Matcher yearOfPublishingMatcher = yearOfPublishingPattern.matcher(booksStringList.get(i));
            Matcher bookTypeMatcher = bookTypePattern.matcher(booksStringList.get(i));
            while (bookNameMatcher.find())
                book.setBookName(bookNameMatcher.group().substring(10, bookNameMatcher.group().length() - 1));
            while (bookAuthorMatcher.find())
                book.setBookAuthor(bookAuthorMatcher.group().substring(12, bookAuthorMatcher.group().length() - 1));
            while (bookPublishingMatcher.find())
                book.setBookPublishing(bookPublishingMatcher.group().substring(16, bookPublishingMatcher.group().length() - 1));
            while (yearOfPublishingMatcher.find())
                book.setYearOfPublishing(yearOfPublishingMatcher.group().substring(18, yearOfPublishingMatcher.group().length() - 1));
            while (bookTypeMatcher.find())
                book.setBookType(bookTypeMatcher.group().substring(10, bookTypeMatcher.group().length() - 1));
            books.add(book);
        }
        this.books = books;
    }

    public String booksToString(){
        String booksString = "";
        for(Book book : books){
            booksString = booksString + "bookName: " + book.getBookName() + "; bookAuthor: " + book.getBookAuthor() +
                    "; bookPublishing: " + book.getBookPublishing() + "; yearOfPublishing: " + book.getYearOfPublishing() +
                    "; bookType: " + book.getBookType() + ";\n";
        }
        return booksString;
    }

    public void saveBooksInFile() {
        try (FileOutputStream fos = new FileOutputStream(BOOKS_PATH)) {
            // перевод строки в байты
            byte[] buffer = booksToString().getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}