package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFile {
    private String name;
    private String currentPath;
    private String parentPath;
    private File textFile;

    TextFile(String parentPath, int a) { //конструктор создания нового файла
        this.parentPath = parentPath;
        createTextFile(parentPath);
    }

    TextFile(String currentPath) { //конструктор инициализации существующего файла
        textFile = new File(currentPath);
        this.currentPath = currentPath;
        this.parentPath = textFile.getParent();
        this.name = textFile.getName();
    }

    private void createTextFile(String parentPath) { //метод создания нового файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла: ");
        String name = scanner.next();
        name = name + ".txt";
        this.name = name;
        currentPath = parentPath + "/" + name;
        textFile = new File(currentPath);
        try {
            textFile.createNewFile();
            System.out.println("Файл с именем " + name + " создан");
        } catch (IOException e) {
            System.out.println("Файл с именем " + name + " уже существует");
        }
    }

    public void printFile() { //функция вывода содержимого файла
        try {
            FileReader fileReader = new FileReader(textFile.getPath());
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public void writeFile() { //функция дополнения файла
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку, которую которой вы хотите дополнить файл: ");
        String str = scanner.nextLine();
        try {
            FileWriter fileWriter = new FileWriter(textFile.getPath(), true);
            fileWriter.write(str);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getTextFile() {
        return textFile;
    }

    public String getParent() {
        return textFile.getParent();
    }

    public String getName() {
        return name;
    }
}
