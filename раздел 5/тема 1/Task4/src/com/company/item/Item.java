package com.company.item;

public class Item {
    private int type;
    private String typeName;
    private int price;
    private String rarityName;
    private int rarity;

    public Item() {
        int buf;
        while (this.rarity != 4) { //случайная установка редкости предмета
            buf = (int) (Math.random() * 2);
            if (buf == 1) {
                break;
            } else {
                this.rarity++;
            }
        }
        switch (this.rarity) { //конвертировать уровень редкости из числа в строку
            case 0:
                this.rarityName = "Common";
                this.price = 50 + (int) (Math.random() * 50);
                break;
            case 1:
                this.rarityName = "Rare";
                this.price = 200 + (int) (Math.random() * 200);
                break;
            case 2:
                this.rarityName = "Mystic";
                this.price = 800 + (int) (Math.random() * 800);
                break;
            case 3:
                this.rarityName = "Immortal";
                this.price = 3200 + (int) (Math.random() * 3200);
                break;
            case 4:
                this.rarityName = "Arcane";
                this.price = 12800 + (int) (Math.random() * 12800);
                break;
        }
        type = (int) (Math.random() * 2); //установка типа предмета
        switch (this.type) {
            case 0:
                this.typeName = "Sword";
                break;
            case 1:
                this.typeName = "Armor";
                break;
            case 2:
                this.typeName = "Staff";
                break;
            case 3:
                this.typeName = "Shield";
                break;
            case 4:
                this.typeName = "Axe";
                break;
        }
    }

    public void print() { //вывод на экран
        System.out.println("    Предмет: " + typeName);
        System.out.println("    Редкость: " + rarityName);
        System.out.println("    Цена: " + price + "$");
    }

    public int getPrice() {
        return price;
    }
}
