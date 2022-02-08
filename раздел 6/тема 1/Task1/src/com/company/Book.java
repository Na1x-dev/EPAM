package com.company;

public class Book {
    private String bookName;
    private String bookAuthor;
    private String bookPublishing;
    private String yearOfPublishing;
    private String bookType;

    Book() {
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookPublishing(String bookPublishing) {
        this.bookPublishing = bookPublishing;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookPublishing() {
        return bookPublishing;
    }

    public String getBookType() {
        return bookType;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPublishing='" + bookPublishing + '\'' +
                ", yearOfPublishing='" + yearOfPublishing + '\'' +
                ", bookType='" + bookType + '\'' +
                '}';
    }
}
