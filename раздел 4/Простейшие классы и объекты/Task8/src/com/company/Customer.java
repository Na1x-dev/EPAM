package com.company;

import java.util.Comparator;
import java.util.Scanner;

public class Customer {
    private long id;
    private String firstname;
    private String lastname;
    private String patronymic; //отчество
    private String address;
    private long cardNum;
    private long bankAccNum;
    private static int ID;

    Customer(String firstname, String lastname, String patronymic, String address, long cardNum, long bankAccNum) {
        this.id = ID++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.address = address;
        this.cardNum = cardNum;
        this.bankAccNum = bankAccNum;
    }

    Customer() {
        this.id = ID++;
        this.firstname = "Иван";
        this.lastname = "Иванов";
        this.patronymic = "Иванович";
        this.address = "г. Иваново, ул. Иванова, д. 77, кв. 22";
        this.cardNum = 1111111111111111l;
        this.bankAccNum = 1l;
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public long getCardNum() {
        return cardNum;
    }

    public long getBankAccNum() {
        return bankAccNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", cardNum=" + cardNum +
                ", bankAccNum=" + bankAccNum +
                '}';
    }

    public void print() {
        System.out.println(
                "id: " + id +
                ", Имя: " + firstname +
                ", Фамилия: " + lastname +
                ", Отчество: " + patronymic +
                ", Адрес: " + address +
                ", Номер карты: " + cardNum +
                ", Номер банковского счета: " + bankAccNum);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setCardNum(long cardNum) {
        this.cardNum = cardNum;
    }

    public void setBankAccNum(long bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public static Customer setCustomer(Scanner scanner) {
        Customer customer = new Customer("", "", "", "", 0, 0);
        System.out.print("firstname: ");
        customer.firstname = scanner.nextLine();
        customer.firstname = scanner.nextLine();
        System.out.print("lastname: ");
        customer.lastname = scanner.nextLine();
        System.out.print("patronymic: ");
        customer.patronymic = scanner.nextLine();
        System.out.print("address: ");
        customer.address = scanner.nextLine();
        System.out.print("cardNum: ");
        customer.cardNum = scanner.nextLong();
        System.out.print("bankAccNum: ");
        customer.bankAccNum = scanner.nextLong();
        return customer;
    }

    public static class ByNameComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer left, Customer right) {
            if (!left.lastname.equals(right.lastname))
                return left.lastname.compareTo(right.lastname);
            if (!left.firstname.equals(right.firstname))
                return left.firstname.compareTo(right.firstname);
            return left.patronymic.compareTo(right.patronymic);
        }
    }

}