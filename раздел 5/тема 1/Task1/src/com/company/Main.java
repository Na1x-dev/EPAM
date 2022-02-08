package com.company;

//Задача 1.
//Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
//вывести на консоль содержимое, дополнить, удалить.

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String currentPath = "root";
        String mainFolderName = "root";
        initializeRootDirectory(mainFolderName);
        while (true) {
            System.out.println("Текущая папка: " + currentPath);
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Открыть папку или файл");
            System.out.println("2. Создать папку");
            System.out.println("3. Создать папку и перейти в нее");
            System.out.println("4. Показать список папок и файлов");
            System.out.println("5. Создать текстовый файл");
            System.out.println("6. Создать текстовый файл и открыть его");
            System.out.println("7. Переименовать папку или файл");
            System.out.println("8. Удалить папку или файл");
            int key = scanner.nextInt();
            if (new File(currentPath).isDirectory()) {
                Directory folder = new Directory(currentPath);
                switch (key) {
                    case 1: //открыть папку или файл
                        currentPath = folder.choiceFolder(mainFolderName);
                        if (new File(currentPath).isFile())
                            currentPath = folder.fileOpen(currentPath);
                        break;
                    case 2: //создать папку
                        folder.addNewDirectory();
                        break;
                    case 3: //создать папку и перейти в нее
                        String nameOfNewDirectory = folder.addNewDirectory();
                        currentPath = currentPath + "/" + nameOfNewDirectory;
                        break;
                    case 4: //показать список папок и файлов
                        folder.printForShowFiles();
                        break;
                    case 5: //создать текстовый файл
                        folder.addNewTextFile();
                        break;
                    case 6: //создать текстовый файл и открыть его
                        String nameOfNewTextFile = folder.addNewTextFile();
                        currentPath = currentPath + "/" + nameOfNewTextFile;
                        currentPath = folder.fileOpen(currentPath);
                        break;
                    case 7: //переименовать папку или файл
                        folder.rename(mainFolderName);
                        break;
                    case 8: //удалить папку или файл
                        folder.delete(mainFolderName);
                        break;
                }
            }
        }
    }

    static void initializeRootDirectory(String mainFolderName) { //инициализация корневой директории
        File rootDirectory = new File(mainFolderName);
        if (!rootDirectory.exists()) {
            rootDirectory.mkdir();
        }
    }
}
