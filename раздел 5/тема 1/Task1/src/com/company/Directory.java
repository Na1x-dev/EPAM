package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Directory {
    private String currentPath;
    private String parentPath;
    private String name;
    private File folder;
    private ArrayList<Directory> directories = new ArrayList<>();
    private ArrayList<TextFile> textFiles = new ArrayList<>();

    Directory(String parentPath, int a) { // конструктор для создания новой папки
        this.parentPath = parentPath;
        createDirectory(parentPath);
    }

    Directory(String currentPath) { //конструктор для инициализации существующей папки
        folder = new File(currentPath);
        this.currentPath = currentPath;
        this.parentPath = folder.getParent();
        this.name = folder.getName();
        for (File file : folder.listFiles()) { //получение списка файлов и папок
            if (file.isDirectory()) {
                directories.add(new Directory(currentPath + "/" + file.getName()));
            } else if (file.isFile()) {
                textFiles.add(new TextFile(currentPath + "/" + file.getName()));
            }
        }
    }

    private void createDirectory(String parentPath) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя папки: ");
        String name = scanner.next();
        this.name = name;
        currentPath = parentPath + "/" + name; //местоположение директории
        folder = new File(currentPath); //создание объекта директории
        if (folder.mkdir()) { //создание директории
            System.out.println("Папка с именем " + name + " создана");
        } else {
            System.out.println("Папка с именем " + name + " уже существует");
        }
    }

    public void printForShowFiles() { //вывод файлов и папок директории
        System.out.println("-----------------------------------------------------------------------------");
        for (Directory directory : directories) {
            System.out.println("- " + directory.getName());
        }
        for (TextFile textFile : textFiles) {
            System.out.println("- " + textFile.getName());
        }
        if (directories.size() + textFiles.size() == 0) {
            System.out.println("                               Папка пуста");
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void printForChoiceFiles() { //вывод файлов и папок директории для меню выбора
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("0. <---");
        int count = 1;
        for (Directory directory : directories) {
            System.out.println(count + ". " + directory.getName());
            count++;
        }
        for (TextFile textFile : textFiles) {
            System.out.println(count + ". " + textFile.getName());
            count++;
        }
        System.out.println("-----------------------------------------------------------------------------");
    }

    public String addNewDirectory() { //создать новую папку в директории
        directories.add(new Directory(currentPath, 1));
        return directories.get(directories.size() - 1).getName();
    }

    public String addNewTextFile() { //создать новый файл в директории
        textFiles.add(new TextFile(currentPath, 1));
        return textFiles.get(textFiles.size() - 1).getName();
    }

    public String choiceFolder(String mainFolderName) { //функция перемещения по папкам и файлам
        Scanner scanner = new Scanner(System.in);
        String currentPath = folder.getPath();
        printForChoiceFiles();
        int key = scanner.nextInt();
        if (key == 0 && !folder.getName().equals(mainFolderName)) { //если выбран элемент под номером 0 и текущая директория не root - вернуться назад
            currentPath = folder.getParent();
        } else if (key > 0 && key <= directories.size()) { //если выбран элемент от 1 до количества папок в директории - перейти в папку
            currentPath = directories.get(key - 1).folder.getPath();
        } else if (key > directories.size() && key <= directories.size() + textFiles.size()) { //если выбран элемент от количества папок в директории + 1 и до количества файлов в директории - открыть файл
            currentPath = textFiles.get(key - 1 - directories.size()).getTextFile().getPath();
        }
        //если число выйдет за границы - директория останется прежней
        return currentPath;
    }

    public void rename(String mainFolderName) { //функция переименования папок и файлов
        String currentPath = choiceFolder(mainFolderName);
        File file = new File(currentPath);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Старое имя файла: " + file.getName());
        System.out.println("Введите новое имя файла");
        String newName = scanner.next();
        if (file.isDirectory())
            file.renameTo(new File(file.getParent() + "/" + newName));
        else if (file.isFile())
            file.renameTo(new File(file.getParent() + "/" + newName + ".txt"));
    }

    public void delete(String mainFolderName) { //функция удаления папок и файлов
        String currentPath = choiceFolder(mainFolderName);
        File file = new File(currentPath);
        if (file.delete()) {
            System.out.println("Объект с именем " + file.getName() + " удален");
        } else {
            System.out.println("Объект с именем " + file.getName() + " НЕ удален. Возможно вы пытаетесь удалить не пустую папку");
        }
    }

    public String fileOpen(String currentPath) { //функция открытия файлов
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Вывести содержимое файла");
        System.out.println("2. Дополнить содержимое файла");
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        TextFile textFile = new TextFile(currentPath);
        switch (key) {
            case 1:
                textFile.printFile();
                break;
            case 2:
                textFile.printFile();
                textFile.writeFile();
                break;
        }
        currentPath = textFile.getParent();
        return currentPath;
    }

    public String getName() {
        return name;
    }
}


