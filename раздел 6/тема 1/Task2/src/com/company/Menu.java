package com.company;

import java.util.Scanner;

public class Menu {
    private Notes notes;

    Menu() {
        int key = 0;
        notes = new Notes();
        while (key != 4) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Создать заметку");
            System.out.println("2. Просмотр всех заметок");
            System.out.println("3. Показать заметки по введенному параметру");
            System.out.println("4. Выход");

            do {
                System.out.println("Введите пункт меню: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                key = scanner.nextInt();
            } while (key <= 0 || key >= 5);
            switch (key) {
                case 1:
                    notes.addNewNote();
                    break;
                case 2:
                    notes.print();
                    break;
                case 3:
                    notes.findNotesOnParameter();
                    break;
                case 4:
                    notes.save();
                    break;
            }
        }
    }
}
