package com.company;

public class Wheel {
    private final int diameter;
    private final int width;
    private boolean state = true;

    Wheel(int diameter, int width){
        this.diameter = diameter;
        this.width = width;
    }

     public void spin(){
        System.out.println("Колесо крутится...");
        if((int) (Math.random() * 10) == 5){
            state = false;
        }
     }

    public boolean getState() {
        return state;
    }
}
