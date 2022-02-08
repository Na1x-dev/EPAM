package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Note {
    private String theme;
    private String date;
    private String email;
    private String message;

    Note() {
        scanTheme();
        scanDate();
        scanEmail();
        scanMessage();
    }

    Note(String data) {

        Pattern themePattern = Pattern.compile("theme: \\'[^\\']+\\'");
        Pattern datePattern = Pattern.compile("date: \\'[^\\']+\\'");
        Pattern emailPattern = Pattern.compile("email: \\'[^\\']+\\'");
        Pattern messagePattern = Pattern.compile("message: \\'[^\\']+\\'");

            Matcher themeMatcher = themePattern.matcher(data);
            Matcher dateMatcher = datePattern.matcher(data);
            Matcher emailMatcher = emailPattern.matcher(data);
            Matcher messageMatcher = messagePattern.matcher(data);

        while(themeMatcher.find()) {
            String rowTheme = themeMatcher.group();
            this.theme = rowTheme.substring(8, rowTheme.length()-1);
        }

        while(dateMatcher.find())
        {
            String rowDate = dateMatcher.group();
            this.date = rowDate.substring(7, rowDate.length()-1);
        }
        while(emailMatcher.find())
        {
            String rowEmail = emailMatcher.group();
            this.email = rowEmail.substring(8, rowEmail.length()-1);
        }
        while(messageMatcher.find())
        {
            String rowMessage = messageMatcher.group();
            this.message = rowMessage.substring(10, rowMessage.length()-1);
        }

    }

    public void print(){
        System.out.println("Заметка: ");
        System.out.println("    Тема: " + this.theme);
        System.out.println("    Дата: " + this.date);
        System.out.println("    E-мейл: " + this.email);
        System.out.println("    Сообщение: " + this.message);
    }

    public void scanTheme() {

        Pattern pattern = Pattern.compile("[А-я ,()A-z]+");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите тему заметки: ");
            while (!scanner.hasNextLine()) {
                System.out.println("Введите коректную тему заметки!");
                scanner.next();
            }
            theme = scanner.nextLine();
            matcher = pattern.matcher(theme);
        } while (!matcher.matches());
    }

    public void scanDate() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        this.date = ft.format(date);
    }

    public void scanEmail() {

        Pattern pattern = Pattern.compile("([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}");
        Matcher matcher;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите e-mail заметки: ");
            while (!scanner.hasNextLine()) {
                System.out.println("Введите коректный e-mail заметки!");
                scanner.next();
            }
            email = scanner.nextLine();
            matcher = pattern.matcher(email);
        } while (!matcher.matches());
    }

    public void scanMessage() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите сообщение заметки: ");
            while (!scanner.hasNextLine()) {
                System.out.println("Введите коректное сообщение заметки!");
                scanner.next();
            }
            this.message = scanner.nextLine();
        } while (this.message.equals(""));
    }

    public String compileNote(){
        String note = "{theme: '" + this.theme + "'; date: '" + this.date + "'; email: '" + this.email + "'; message: '" + this.message + "';}\n";
        return note;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public String getTheme() {
        return theme;
    }

    public String getMessage() {
        return message;
    }


}


// целые числа - INT
// десятичные числа - DEC
// числа с плавающей точкой - FLOAT(точность)
// DOUBLE PRECISION
// CHAR
// VARCHAR - строки переменной длины
// CURRENCY
// дата и время