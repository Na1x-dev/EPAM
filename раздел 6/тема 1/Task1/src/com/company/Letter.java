package com.company;

public class Letter {
    private Book book;
    private String letterText;
    private boolean readStatus;

    Letter(){
        letterText = "";
        book = new Book();
        readStatus = false;
    }

    public Book getBook() {
        return book;
    }

    public String getLetterText() {
        return letterText;
    }

    public boolean getReadStatus() {
        return readStatus;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "book=" + book +
                ", letterText='" + letterText + '\'' +
                ", readStatus=" + readStatus +
                '}';
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }
}
