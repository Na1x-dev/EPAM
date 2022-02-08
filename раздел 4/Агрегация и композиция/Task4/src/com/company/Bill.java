package com.company;

import java.util.Comparator;
import java.util.Scanner;

public class Bill {
    private boolean status;
    private long number;
    private int balance;

    Bill(int balance, long number) {
        this.balance = balance;
        this.number = number;
        this.status = true;
    }

    public void block() {
        this.status = false;
    }

    public void unblock() {
        this.status = true;
    }

    public boolean getStatus() {
        return this.status;
    }

    public long getNumber() {
        return number;
    }

    public int getBalance() {
        if (getStatus())
            return balance;
        else
            return 0;
    }

    public void addMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество денег, которое нужно добавить");
        int money = scanner.nextInt();
        if (status)
            this.balance += money;
        else
            System.out.println("Счет заблокирован, операции не возможны");
    }

    public void spendMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество денег, которое нужно потратить");
        int money = scanner.nextInt();
        if (status)
            this.balance -= money;
        else
            System.out.println("Счет заблокирован, операции не возможны");
    }

    public void print() {
        if (status) {
            System.out.println("Номер счета: " + this.number);
            System.out.println("Статус: активен");
            System.out.println("Баланс: " + this.balance);
        } else {
            System.out.println("Номер счета: " + this.number);
            System.out.println("Статус: заблокирован");
        }
    }

}
