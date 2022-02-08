package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private String email;
    private String username;
    private List<Letter> letters = new ArrayList<>();

    Email(User user) {
        username = user.getUsername();
        email = username + "@mail.com";
        initialiseLettersList();
    }

    public static void initEmailFile(User user) {
        File emailFile = new File("emails/" + user.getUsername() + ".txt");
        if (!emailFile.exists()) {
            try {
                emailFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> getLettersStringList() {
        StringBuilder lettersString = new StringBuilder();
        String[] lettersStringArray;
        List<String> lettersStringList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream("emails/" + username + ".txt")) {
            BufferedReader in = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            int i = -1;
            while ((i = in.read()) != -1) {
                lettersString.append((char) i);
            }
            lettersStringArray = lettersString.toString().split("\n");
            lettersStringList = Arrays.asList(lettersStringArray);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lettersStringList;
    }

    private void initialiseLettersList() {
        List<String> lettersStringList = getLettersStringList();
        List<Letter> letters = new ArrayList<>();
        Pattern LetterTextPattern = Pattern.compile("letterText: .+?;");
        Pattern bookNamePattern = Pattern.compile("bookName: .+?;");
        Pattern bookAuthorPattern = Pattern.compile("bookAuthor: .+?;");
        Pattern bookPublishingPattern = Pattern.compile("bookPublishing: .+?;");
        Pattern yearOfPublishingPattern = Pattern.compile("yearOfPublishing: .+?;");
        Pattern bookTypePattern = Pattern.compile("bookType: .+?;");
        Pattern readStatusPattern = Pattern.compile("readStatus: .+?;");
        for (int i = 0; i < lettersStringList.size(); i++) {
            Letter letter = new Letter();
            Matcher LetterTextMatcher = LetterTextPattern.matcher(lettersStringList.get(i));
            Matcher bookNameMatcher = bookNamePattern.matcher(lettersStringList.get(i));
            Matcher bookAuthorMatcher = bookAuthorPattern.matcher(lettersStringList.get(i));
            Matcher bookPublishingMatcher = bookPublishingPattern.matcher(lettersStringList.get(i));
            Matcher yearOfPublishingMatcher = yearOfPublishingPattern.matcher(lettersStringList.get(i));
            Matcher bookTypeMatcher = bookTypePattern.matcher(lettersStringList.get(i));
            Matcher readStatusMatcher = readStatusPattern.matcher(lettersStringList.get(i));
            while (LetterTextMatcher.find())
                letter.setLetterText(LetterTextMatcher.group().substring(12, LetterTextMatcher.group().length() - 1));
            while (bookNameMatcher.find())
                letter.getBook().setBookName(bookNameMatcher.group().substring(10, bookNameMatcher.group().length() - 1));
            while (bookAuthorMatcher.find())
                letter.getBook().setBookAuthor(bookAuthorMatcher.group().substring(12, bookAuthorMatcher.group().length() - 1));
            while (bookPublishingMatcher.find())
                letter.getBook().setBookPublishing(bookPublishingMatcher.group().substring(16, bookPublishingMatcher.group().length() - 1));
            while (yearOfPublishingMatcher.find())
                letter.getBook().setYearOfPublishing(yearOfPublishingMatcher.group().substring(18, yearOfPublishingMatcher.group().length() - 1));
            while (bookTypeMatcher.find())
                letter.getBook().setBookType(bookTypeMatcher.group().substring(10, bookTypeMatcher.group().length() - 1));
            while (readStatusMatcher.find())
                letter.setReadStatus(Boolean.parseBoolean(readStatusMatcher.group().substring(12, readStatusMatcher.group().length() - 1)));
            if (letter.getBook().getBookName() != null) {
                letters.add(letter);
            }
        }
        this.letters = letters;
    }

    public String lettersToString() {
        String lettersString = "";
        for (Letter letter : letters) {
            lettersString = lettersString + "letterText: " + letter.getLetterText() + "; bookName: " +
                    letter.getBook().getBookName() + "; bookAuthor: " + letter.getBook().getBookAuthor() +
                    "; bookPublishing: " + letter.getBook().getBookPublishing() + "; yearOfPublishing: " +
                    letter.getBook().getYearOfPublishing() + "; bookType: " + letter.getBook().getBookType() +
                    "; readStatus: " + letter.getReadStatus() + ";\n";
        }
        return lettersString;
    }

    public void saveLettersInFile() {
        try (FileOutputStream fos = new FileOutputStream("emails/" + username + ".txt")) {
            // перевод строки в байты
            byte[] buffer = lettersToString().getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createNotificationLetter(Book book) {
        Letter newLetter = new Letter();
        newLetter.setLetterText("В каталоге появилась новая книга: ");
        newLetter.setBook(book);
        letters.add(newLetter);
        saveLettersInFile();
    }

    public void createSuggestionLetter(Book book) {
        Letter newLetter = new Letter();
        newLetter.setLetterText("Предложение добавить новую книгу: ");
        newLetter.setBook(book);
        letters.add(newLetter);
        saveLettersInFile();
    }

    public List<Letter> getLetters() {
        return letters;
    }
}
