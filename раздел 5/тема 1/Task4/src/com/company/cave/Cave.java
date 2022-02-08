package com.company.cave;

import com.company.treasure.Treasure;
import java.util.ArrayList;
import java.util.Scanner;

public class Cave {
    private ArrayList<Treasure> treasures = new ArrayList<>();

    public Cave() { //генерация 100 сокровищ
        for (int i = 0; i < 100; i++) {
            treasures.add(new Treasure());
        }
    }

    public void print() {
        Scanner scanner = new Scanner(System.in);
        int key = 0;
        int navigation = 0;
        while (key != 3) {
            for (int i = navigation * 5; i < (navigation * 5 + 5); i++) {
                System.out.println("Сокровищница #" + (i + 1)); //вывод на экран 5 сокровищ
                treasures.get(i).print();
                System.out.println("Стоимость сокровищницы: " + treasures.get(i).getPrice());
                System.out.println();
            }
            System.out.println("1. Вперед");
            System.out.println("2. Назад");
            System.out.println("3. В меню");
            key = scanner.nextInt();
            switch (key) {
                case 1:
                    navigation++;
                    if (navigation > 19) {
                        navigation = 0;
                    }
                    break;
                case 2:
                    navigation--;
                    if (navigation < 0) {
                        navigation = 19;
                    }
                    break;
            }
            System.out.println("---------------------------------------------------------------------------------");
        }
    }

    public void theMostExpansive() { //поиск самого дорогого сокровища
        int max = 0;
        int bufI = 0;
        for (int i = 0; i < treasures.size(); i++) {
            if (max < treasures.get(i).getPrice()) {
                max = treasures.get(i).getPrice();
                bufI = i;
            }
        }
        System.out.println("Сокровищница с максимальной стоимостью: ");
        System.out.println("Сокровищница #" + (bufI + 1));
        treasures.get(bufI).print();
        System.out.println("Стоимость сокровищницы: " + treasures.get(bufI).getPrice());
        System.out.println("---------------------------------------------------------------------------------");
    }

    public void forAGivenAmount() { //сокровища на требуемую сумму
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите требуемую сумму: ");
        int sum = scanner.nextInt();
        int max = 0;
        ArrayList<Integer> massI = new ArrayList<>();
        int bufI = 0;
        int sumRes = 0;
        for (int i = 0; i < treasures.size(); i++) { //сначала поиск самого дорогого сокровища
            if (max < treasures.get(i).getPrice() && treasures.get(i).getPrice() <= sum) {
                max = treasures.get(i).getPrice();
                bufI = i;
            }
        }
        sumRes += max;
        massI.add(bufI);
        for (int i = 0; i < treasures.size(); i++) { //добираем сумму всеми остальными
            if (sum >= sumRes + treasures.get(i).getPrice()) {
                sumRes += treasures.get(i).getPrice();
                massI.add(i);
            }
        }
        System.out.println("Требуемая сумма: " + sum);
        for (int i : massI) {
            System.out.println("Сокровищница #" + (i + 1));
            treasures.get(i).print();
            System.out.println("Стоимость сокровищницы: " + treasures.get(i).getPrice());
        }
        System.out.println("Итоговая стоимость сокровищниц: " + sumRes);
        System.out.println("---------------------------------------------------------------------------------");
    }
}