package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Bills {
    private ArrayList<Bill> bills = new ArrayList<>();

    Bills(Bill[] bills) {
        this.bills.addAll(Arrays.asList(bills));
    }

    Bills() {}

    protected void addBill(Bill bill) {
        this.bills.add(bill);
    }

    protected void printBills() {
        for (Bill bill : bills) {
            bill.print();
        }
    }

    protected void clear() {
        bills.clear();
    }

    public void findAndPrint(int index) {
        System.out.println(index + "-й счет: ");
        bills.get(index).print();
    }

    public void findAndPrint(long number) {
        for (Bill bill : bills) {
            if (bill.getNumber() == number) {
                bill.print();
            }
        }
    }

    public Bill find(int index) {
        return bills.get(index);
    }

    public Bill find(long number) {
        Bill bufBill = null;
        for (Bill bill : bills) {
            if (bill.getNumber() == number) {
                bufBill = bill;
            }
        }
        return bufBill;
    }

    public void sort() {
        Bill buf;
        boolean ready = false;
        while (!ready) {
            ready = true;
            for (int i = 1; i < bills.size(); i++) {
                if (bills.get(i).getNumber() < bills.get(i - 1).getNumber()) {
                    buf = bills.get(i);
                    bills.set(i, bills.get(i - 1));
                    bills.set(i - 1, buf);
                    ready = false;
                }
            }
        }
    }

    public void printSum() {
        int sum = 0;
        for (Bill bill : bills) {
            sum += bill.getBalance();
        }
        System.out.println("Сумма баланса всех счетов: " + sum);
    }

    public void printTwoSums() {
        int sumPositive = 0;
        int sumNegative = 0;
        for (Bill bill : bills) {
            if (bill.getBalance() > 0) {
                sumPositive += bill.getBalance();
            } else if (bill.getBalance() < 0) {
                sumNegative += bill.getBalance();
            }
        }
        System.out.println("Сумма счетов с положительным балансом: " + sumPositive);
        System.out.println("Сумма счетов с отрицательным балансом: " + sumNegative);
    }

    public int getSize() {
        return bills.size();
    }
}
