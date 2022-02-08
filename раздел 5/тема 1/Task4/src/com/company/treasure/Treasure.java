package com.company.treasure;

import com.company.item.Item;
import java.util.ArrayList;

public class Treasure {
    private int price;
    private ArrayList<Item> items = new ArrayList<>();

    public Treasure() { //создание случайного сокровища
        int n = 1 + (int) (Math.random() * 6);
        for (int i = 0; i < n; i++) {
            this.items.add(new Item());
            this.price += this.items.get(i).getPrice();
        }
    }

    public void print(){ //вывести предметы сокровища
        for(Item item : items){
            item.print();
        }
    }

    public int getPrice() {
        return price;
    }
}


