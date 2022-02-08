package com.company;

import java.util.Scanner;

public class Client {
    Bills bills = new Bills();

    Client(Bill bill) {
        bills.clear();
        bills.addBill(bill);
    }

    public void addBill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите начальную сумму счета: ");
        int balance = scanner.nextInt();
        long number = 1000000000000L + (long) (Math.random() * 8999999999999999L);
        bills.addBill(new Bill(balance, number));
    }
}
