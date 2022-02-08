package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Customers {
    private ArrayList<Customer> customers;

    Customers() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void print() {
        for (Customer customer : customers) {
            customer.print();
        }
    }

    public void sortByName() {
        Collections.sort(customers, new Customer.ByNameComparator());
    }

    public void printIfCardIn(int a, int b) {
        for (Customer customer : customers) {
            if (customer.getCardNum() >= a && customer.getCardNum() <= b)
                customer.print();
        }
    }
}