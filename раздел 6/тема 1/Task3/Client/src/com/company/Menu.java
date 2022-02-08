package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private int buffPort;
    private  Connector connectionToClient;


    Menu(){
        this.buffPort = useLastPort();
        mainMenu();
        connectionToClient = new Connector();
    }

    public void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Использовать порт " + buffPort);
        System.out.println("2. Ввести новый порт");
        int key = 0;
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >= 3);
        switch (key){
            case 1:
                useLastPort();
                break;
            case 2:
                enterNewPort();
                Connector.setPort(buffPort);
                break;
        }
    }

    public void enterNewPort() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новый порт: ");
        this.buffPort = scanner.nextInt();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("port.txt");
            fileOutputStream.write(String.valueOf(buffPort).getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Integer useLastPort() {
        String stringPort = "";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("port.txt");
            int i;
            while ((i = fileInputStream.read()) != -1) {
                stringPort += (char) i;
            }
            Connector.setPort(Integer.valueOf(stringPort));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(stringPort);
    }
    

}
