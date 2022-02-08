package com.company;

import java.util.Scanner;

//3. Создать объект класса Государство, используя классы Область, Район, Город. Методы: вывести на консоль
//столицу, количество областей, площадь, областные центры.

public class Main {

    public static void main(String[] args) {
        District d1 = new District(new City("Брест", 400000), 300);
        District d2 = new District(new City("Пинск", 300000), 350);
        District d3 = new District(new City("Барановичи", 250000), 370);

        District d4 = new District(new City("Гродно", 350000), 150);
        District d5 = new District(new City("Лида", 200000), 180);
        District d6 = new District(new City("Новогрудок", 150000), 210);

        District d7 = new District(new City("Минск", 2000000), 450);
        District d8 = new District(new City("Солигорск", 100000), 260);
        District d9 = new District(new City("Борисов", 200000), 270);

        Region r1 = new Region(new City("Брест", 400000), new District[]{d1, d2, d3});
        Region r2 = new Region(new City("Гродно", 350000), new District[]{d4, d5, d6});
        Region r3 = new Region(new City("Минск", 2000000), new District[]{d7, d8, d9});

        State state = new State(new City("Минск", 2000000), new Region[]{r1, r2, r3}, "Беларусь", 207);

        while (true){
            System.out.println("Выберите один из пунктов меню:");
            System.out.println("1. Вывести столицу");
            System.out.println("2. Вывести количество областей");
            System.out.println("3. Вывести площадь государства");
            System.out.println("4. Вывести областные центры");

            Scanner scanner = new Scanner(System.in);
            int key = scanner.nextInt();

            switch (key){
                case 1:
                    state.printCapital();
                    break;
                case 2:
                    state.printNumOfRegions();
                    break;
                case 3:
                    state.printArea();
                    break;
                case 4:
                    state.printRegionalCenters();
                    break;
            }
        }
    }
}
