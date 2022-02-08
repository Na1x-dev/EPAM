package com.company;

public class InStock {
    private int potato;
    private int honey;
    private int wasabi;
    private int strings;
    private int bread;
    private int water;

    InStock() {
        this.potato = 16000;
        this.honey = 11000;
        this.wasabi = 3000;
        this.strings = 50000;
        this.bread = 9;
        this.water = 33;
    }

    public int get(String name) { //получить оставшееся количество на складе
        int value = 0;
        switch (name) {
            case "Картофель":
                value = this.potato;
                break;
            case "Мед":
                value = this.honey;
                break;
            case "Васаби":
                value = this.wasabi;
                break;
            case "Нитки":
                value = this.strings;
                break;
            case "Хлеб":
                value = this.bread;
                break;
            case "Вода":
                value = this.water;
                break;
        }
        return value;
    }

    public void set(String name, int value) { //установить количество на складе
        switch (name) {
            case "Картофель":
                this.potato = value;
                break;
            case "Мед":
                this.honey = value;
                break;
            case "Васаби":
                this.wasabi = value;
                break;
            case "Нитки":
                this.strings = value;
                break;
            case "Хлеб":
                this.bread = value;
                break;
            case "Вода":
                this.water = value;
                break;
        }
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getBread() {
        return bread;
    }

    public void setBread(int bread) {
        this.bread = bread;
    }

    public int getStrings() {
        return strings;
    }

    public void setStrings(int strings) {
        this.strings = strings;
    }

    public int getWasabi() {
        return wasabi;
    }

    public void setWasabi(int wasabi) {
        this.wasabi = wasabi;
    }

    public int getHoney() {
        return honey;
    }

    public void setHoney(int honey) {
        this.honey = honey;
    }

    public int getPotato() {
        return potato;
    }

    public void setPotato(int potato) {
        this.potato = potato;
    }
}
