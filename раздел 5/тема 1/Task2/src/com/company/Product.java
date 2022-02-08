package com.company;

import java.util.Scanner;

public class Product {
    private String name;
    private String unit;
    private int requiredQuantity; //требуемое количество
    private double unitPrice;
    private double price;

    Product(String name) { //конструктор продукта
        this.name = name;
        addToProduct();
    }

    public void print() { //вывести на экран продукт
        System.out.println("- " + getName() + ", " + getRequiredQuantity() + " " + getUnit() + " - " + getPrice() + "$");
    }

    public void addToProduct() { //метод устанавливает цену за единицу и единицу измерения
        switch (this.name) {
            case "Картофель":
                this.unitPrice = 0.3;
                this.unit = "кг";
                break;
            case "Мед":
                this.unitPrice = 0.1;
                this.unit = "мл";
                break;
            case "Васаби":
                this.unitPrice = 0.1;
                this.unit = "гр";
                break;
            case "Нитки":
                this.unitPrice = 1;
                this.unit = "шт";
                break;
            case "Хлеб":
                this.unitPrice = 1;
                this.unit = "кг";
                break;
            case "Вода":
                this.unitPrice = 0.4;
                this.unit = "л";
                break;
        }
    }

    public void putInBasket(InStock inStock) { //положить продукт в корзину
        Scanner scanner = new Scanner(System.in);
        System.out.println("В наличии имеется: " + inStock.get(name) + " " + unit);
        System.out.println("Введите количество продукта (" + name + "): ");
        int value = scanner.nextInt();
        if (value > inStock.get(name)) { //проверка наличия товара
            System.out.println("Недостаточно товара на складе");
        } else {
            setRequiredQuantity(getRequiredQuantity() + value); //обновить требуемое количество продукта (в корзине)
            setPrice(getUnitPrice() * getRequiredQuantity()); //высчитать стоимость продукта
            inStock.set(name, inStock.get(name) - getRequiredQuantity()); // забрать товар со склада
        }
    }

    public void setRequiredQuantity(int requiredQuantity) {
        this.requiredQuantity = requiredQuantity;
    }

    public int getRequiredQuantity() {
        return requiredQuantity;
    }

    public double getPrice() {
        return price;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
