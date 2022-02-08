package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Calender {

    private ArrayList<Holiday> holidays = new ArrayList<>();
    private int day;
    private int month;
    private String nameOfMonth;
    private int year;
    int dayOfTheWeek;
    int theEndOfMonth;

    Calender() {
        Date date = new Date();
        SimpleDateFormat ft3 = new SimpleDateFormat("yyyy");
        SimpleDateFormat ft2 = new SimpleDateFormat("MM");
        SimpleDateFormat ft1 = new SimpleDateFormat("dd");
        SimpleDateFormat ft4 = new SimpleDateFormat("E");
        this.day = Integer.parseInt(ft1.format(date)); //получение текущей даты
        this.month = Integer.parseInt(ft2.format(date)); //
        this.year = Integer.parseInt(ft3.format(date)); //
        dateStringToInt(ft4.format(date)); //получение порядкового номера дня недели
        initHolidays(); //инициализация праздников
        theEndOfMonth(); //установка последнего дня месяца и названия месяца
    }

    public void initHolidays() { //инициализация праздников
        holidays.add(new Holiday(1, 1, "Новый год"));
        holidays.add(new Holiday(7, 1, "Рождество"));
        holidays.add(new Holiday(23, 2, "День защитника отечества"));
        holidays.add(new Holiday(8, 3, "Женский день"));
        holidays.add(new Holiday(1, 5, "День труда"));
        holidays.add(new Holiday(9, 5, "День победы"));
        holidays.add(new Holiday(3, 7, "День независимости"));
        holidays.add(new Holiday(3, 9, "ТРЕТЬЕ СЕНТЯБРЯ - ДЕНЬ ПРОЩАНЬЯ"));
        holidays.add(new Holiday(13, 9, "День программиста"));
        holidays.add(new Holiday(25, 12, "Католическое рождество"));
    }

    public void print() { //вывод календаря
        System.out.println();
        toStartOfMonth();
        System.out.println(nameOfMonth + " " + year);
        System.out.println("Mo Tu We Th Fr Sa Su");
        for (int i = 0; i < theEndOfMonth; i++) {
            if (day < 1) {
                System.out.print("   ");
                i--;
            } else if (day < 10) {
                System.out.print(" " + day + " ");
            } else {
                System.out.print(day + " ");
            }
            dayOfTheWeek++;
            if (dayOfTheWeek == 8) {
                System.out.println();
                dayOfTheWeek = 1;
            }
            day++;
        }
        printHolidays();
    }

    public int theEndOfMonth() { //установка последнего дня месяца и названия месяца
        switch (this.month) {
            case 1:
                theEndOfMonth = 31;
                nameOfMonth = "January";
                break;
            case 2:
                if (this.year % 4 == 0)
                    theEndOfMonth = 29;
                else
                    theEndOfMonth = 28;
                nameOfMonth = "February";
                break;
            case 3:
                theEndOfMonth = 31;
                nameOfMonth = "March";
                break;
            case 4:
                theEndOfMonth = 30;
                nameOfMonth = "April";
                break;
            case 5:
                theEndOfMonth = 31;
                nameOfMonth = "May";
                break;
            case 6:
                theEndOfMonth = 30;
                nameOfMonth = "June";
                break;
            case 7:
                theEndOfMonth = 31;
                nameOfMonth = "July";
                break;
            case 8:
                theEndOfMonth = 31;
                nameOfMonth = "August";
                break;
            case 9:
                theEndOfMonth = 30;
                nameOfMonth = "September";
                break;
            case 10:
                theEndOfMonth = 31;
                nameOfMonth = "October";
                break;
            case 11:
                theEndOfMonth = 30;
                nameOfMonth = "November";
                break;
            case 12:
                theEndOfMonth = 31;
                nameOfMonth = "December";
                break;
        }
        return theEndOfMonth;
    }

    public void toStartOfMonth() { //на первый день месяца
        while (day > 1) {
            day--;
            dayOfTheWeek--;
            if (dayOfTheWeek == 0) {
                dayOfTheWeek = 7;
            }
        }
        while (dayOfTheWeek > 1) {
            day--;
            dayOfTheWeek--;
        }
    }

    public void dateStringToInt(String dayOfTheWeek) { //перевод дне недели в число
        switch (dayOfTheWeek) {
            case "пн":
                this.dayOfTheWeek = 1;
                break;
            case "вт":
                this.dayOfTheWeek = 2;
                break;
            case "ср":
                this.dayOfTheWeek = 3;
                break;
            case "чт":
                this.dayOfTheWeek = 4;
                break;
            case "пт":
                this.dayOfTheWeek = 5;
                break;
            case "сб":
                this.dayOfTheWeek = 6;
                break;
            case "вс":
                this.dayOfTheWeek = 7;
                break;
        }
    }

    public String dateIntToString() { //перевод номера дня недели в строку
        String dayOfTheWeek = null;

        switch (this.dayOfTheWeek) {
            case 1:
                dayOfTheWeek = "пн";
                break;
            case 2:
                dayOfTheWeek = "вт";
                break;
            case 3:
                dayOfTheWeek = "ср";
                break;
            case 4:
                dayOfTheWeek = "чт";
                break;
            case 5:
                dayOfTheWeek = "пт";
                break;
            case 6:
                dayOfTheWeek = "сб";
                break;
            case 7:
                dayOfTheWeek = "вс";
                break;
        }
        return dayOfTheWeek;
    }

    public void printHolidays() { //показать праздники месяца
        System.out.println();
        System.out.println("Праздники этого месяца: ");
        boolean holidaysWere = false;
        for (Holiday holiday : holidays) {
            if (holiday.getMonth() == this.month) {
                System.out.println(holiday.getDay() + "." + holiday.getMonth() + "." + year + " - " + holiday.getName());
                holidaysWere = true;
            }
        }
        if (!holidaysWere) {
            System.out.println("Праздников в этом месяце нет");
        }
    }

    public void monthAgo() { //переместиться на месяц назад
        while (day > 0) {
            day--;
            dayOfTheWeek--;
            if (dayOfTheWeek == 0) {
                dayOfTheWeek = 7;
            }
        }
        month--;
        if (month < 1) {
            month = 12;
            year--;
        }
        theEndOfMonth();
        day = theEndOfMonth;
    }

    public void monthAhead() { //переместиться на месяц вперед
        theEndOfMonth();
        while (day < theEndOfMonth + 1) {
            day++;
            dayOfTheWeek++;
            if (dayOfTheWeek == 8) {
                dayOfTheWeek = 1;
            }
        }
        month++;
        System.out.println(month);
        if (month > 12) {
            month = 1;
            year++;
        }
        theEndOfMonth();
        day = 1;
    }

    public void findMonth() { //найти месяц и год
        theEndOfMonth();
        int month;
        int year;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        month = scanner.nextInt();
        System.out.println("Введите год: ");
        year = scanner.nextInt();
        while (this.year < year) { //пока год не будет равным указанному, добавлять дни
            this.day++;
            this.dayOfTheWeek++;
            if (this.dayOfTheWeek > 7)
                this.dayOfTheWeek = 1;
            if (this.day > theEndOfMonth()) {
                this.month++;
                this.day = 1;
                if (this.month > 12) {
                    this.year++;
                    this.month = 1;
                }
            }
            theEndOfMonth();
        }
        while (this.year > year) { //пока год не будет равным указанному, отнимать дни
            this.day--;
            this.dayOfTheWeek--;
            if (this.dayOfTheWeek < 1)
                this.dayOfTheWeek = 7;
            if (this.day < 1) {
                this.month--;
                this.day = theEndOfMonth();
                if (this.month < 1) {
                    this.year--;
                    this.month = 12;
                }
            }
            theEndOfMonth();
        }
        while (this.month > month) { //пока месяц не будет равным указанному, отнимать дни
            this.day--;
            this.dayOfTheWeek--;
            if (this.dayOfTheWeek < 1)
                this.dayOfTheWeek = 7;
            if (this.day < 1) {
                this.month--;
                this.day = theEndOfMonth();
            }
            theEndOfMonth();
        }
        while (this.month < month) { //пока год не будет равным указанному, добавлять дни
            this.day++;
            this.dayOfTheWeek++;
            if (this.dayOfTheWeek > 7)
                this.dayOfTheWeek = 1;
            if (this.day > theEndOfMonth()) {
                this.month++;
                this.day = 1;
            }
            theEndOfMonth();
        }
    }
}
