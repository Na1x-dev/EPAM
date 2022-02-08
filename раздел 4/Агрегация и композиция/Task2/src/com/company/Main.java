package com.company;

import java.util.Scanner;

//2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. Методы: ехать, заправляться,
//менять колесо, вывести на консоль марку автомобиля.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car("Nissan", "Skyline R34", new Engine("RB26", 2.6, 6, true, 280, 392));
        while (true) {
            System.out.println("Выберите действие");
            System.out.println("1. Ехать");
            System.out.println("2. Заправить машину");
            System.out.println("3. Запустить двигатель");
            System.out.println("4. Вывести модель в консоль");
            System.out.println("5. Заменить колесо");
            System.out.println("6. Заглушить двигатель");
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    car.go();
                    break;
                case 2:
                    car.refuel();
                    break;
                case 3:
                    car.startEngine();
                    break;
                case 4:
                    car.printModel();
                    break;
                case 5:
                    car.setNewWheel();
                    break;
                case 6:
                    car.stopEngine();
                    break;
            }
        }
    }
}
