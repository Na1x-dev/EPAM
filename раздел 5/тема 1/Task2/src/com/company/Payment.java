package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Payment {

    private ArrayList<Product> products = new ArrayList<>();
    private double price;
    private InStock inStock;

    Payment(InStock inStock) {
        this.inStock = inStock;
    }

    public void addProduct(String name) { //добавить продукт в корзину
        int index = 0;
        boolean thereIs = false;
        for (int i = 0; i < products.size(); i++) { //проверка на наличие одноименного товара в корзине
            if (products.get(i).getName().equals(name)) {
                thereIs = true;
                index = i;
                break;
            }
        }
        if (!thereIs) { //если одноименный товар не присутствует в корзине, то
            Product product = new Product(name); //создать новый объект продукта
            product.putInBasket(inStock); //добавить в корзину
            products.add(product); //добавить в список
            calculateThePrice(); //пересчитать стоимость
        } else { //иначе новый объект не создавать, а добавить к найденному прокту в корзину
            products.get(index).addToProduct();
            products.get(index).putInBasket(inStock);
            calculateThePrice();
        }
    }

    public void calculateThePrice() { //вычислить стоимость
        price = 0;
        for (Product product : products) {
            price += product.getPrice();
        }
    }

    public void checkBasket() { //чистка корзины от мусора
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() == 0) {
                products.remove(i);
            }
        }
    }

    public void print() { //вывести список товаров в корзине
        for (Product product : products) {
            product.print();
        }
        System.out.println("Товаров: " + products.size() + "        стоимость: " + price + "$");
    }

    public void pay() { //оплата товаров
        System.out.println("- - - - - - Чек - - - - - -");
        print();
        products.clear();
        calculateThePrice();
        System.out.println("- - Спасибо за покупку - -");
    }
}
