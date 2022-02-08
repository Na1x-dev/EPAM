package com.company;

public class Car {
    Wheel[] wheels = new Wheel[]{
            new Wheel(18, 245), new Wheel(18, 245), new Wheel(18, 265), new Wheel(18, 265)
    };
    Engine engine;
    String brand;
    String model;

    Car(String brand, String model, Engine engine) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
    }

    public void go() {
        boolean canGo = true;
        for(Wheel w : wheels) {
            if (!w.getState()) {
                canGo = false;
            }
        }
        if (engine.getIsStarted() && canGo) {
            System.out.println("Ра-та-та-та-та");
            for (Wheel w : wheels){
                w.spin();
            }
        }
        else if(!engine.getIsStarted())
            System.out.println("Ра-та-та-та-та невозможно, нужно запустить двигатель");
        else  if(!canGo){
            System.out.println("Ра-та-та-та-та невозможно, нужно заменить колесо");
        }
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public void refuel() {
        System.out.println("Идет заправка машины");
    }

    public void printModel(){
        System.out.println(brand + " " + model);
    }

    public void setNewWheel(){
        for (int i = 0; i<wheels.length;i++){
            if(!wheels[i].getState()){
                wheels[i] = new Wheel(20, 12);
                System.out.println("Колесо заменено");
            }
        }
        System.out.println("Колеса в порядке, можно ехать");
    }
}
