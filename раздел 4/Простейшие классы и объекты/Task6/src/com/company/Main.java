package com.company;

//6. Составьте описание класса для представления времени. Предусмотрте возможности установки времени и
//изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
//недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения времени на
//заданное количество часов, минут и секунд.

import java.util.Scanner;

class Clock {
    private int hour;
    private int minutes;
    private int seconds;

    Clock(int hour, int minutes, int seconds) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        this.minutes = (minutes >= 0 && minutes <= 59) ? minutes : 0;
        this.seconds = (seconds >= 0 && seconds <= 59) ? seconds : 0;
    }

    Clock() {
    }

    public void setTime(int hour, int minutes, int seconds) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
        this.minutes = (minutes >= 0 && minutes <= 59) ? minutes : 0;
        this.seconds = (seconds >= 0 && seconds <= 59) ? seconds : 0;
    }

    public void setHour(int hour) {
        this.hour = (hour >= 0 && hour <= 23) ? hour : 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = (minutes >= 0 && minutes <= 59) ? minutes : 0;
    }

    public void setSeconds(int seconds) {
        this.seconds = (seconds >= 0 && seconds <= 59) ? seconds : 0;
    }

    public String getTime() {
        return hour + ":" + minutes + ":" + seconds;
    }

    public void addHour(int add) {
        this.hour += add;
        while (this.hour > 23) {
            this.hour -= 24;
        }
    }

    public void addMinutes(int add) {
        this.minutes += add;
        while (this.minutes > 59) {
            this.minutes -= 60;
            addHour(1);
        }
    }

    public void addSeconds(int add) {
        this.seconds += add;
        while (this.seconds > 59) {
            this.seconds -= 60;
            addMinutes(1);
        }
    }

    public void subHour(int sub) {
        this.hour -= sub;
        while (this.hour < 0) {
            this.hour += 24;

        }
    }

    public void subMinutes(int sub) {
        this.minutes -= sub;
        while (this.minutes < 0) {
            this.minutes += 60;
            subHour(1);
        }
    }

    public void subSeconds(int sub) {
        this.seconds -= sub;
        while (this.seconds < 0) {
            this.seconds += 60;
            subMinutes(1);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clock clock = new Clock();
        while (true) {
            System.out.println("Время: " + clock.getTime());
            System.out.println("Выберите действие");
            System.out.println("1. Добавить часы");
            System.out.println("2. Добавить минуты");
            System.out.println("3. Добавить секунды");
            System.out.println("4. Вычесть часы");
            System.out.println("5. Вычесть минуты");
            System.out.println("6. Вычесть секунды");
            System.out.println("7. Установить время");
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    System.out.println("Введите количество часов, которое вы хотите добавить: ");
                    clock.addHour(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите количество минут, которое вы хотите добавить: ");
                    clock.addMinutes(scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите количество секунд, которое вы хотите добавить: ");
                    clock.addSeconds(scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Введите количество часов, которое вы хотите вычесть: ");
                    clock.subHour(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Введите количество минут, которое вы хотите вычесть: ");
                    clock.subMinutes(scanner.nextInt());
                    break;
                case 6:
                    System.out.println("Введите количество секунд, которое вы хотите вычесть: ");
                    clock.subSeconds(scanner.nextInt());
                    break;
                case 7:
                    System.out.println("Введите время, которое вы хотите установить");
                    System.out.println("Введите часы: ");
                    clock.setHour(scanner.nextInt());
                    System.out.println("Введите минуты: ");
                    clock.setMinutes(scanner.nextInt());
                    System.out.println("Введите секунды: ");
                    clock.setSeconds(scanner.nextInt());
                    break;
            }
        }
    }
}
