package com.company;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Scanner;
class Connector {

    private static Socket clientSocket;
    private static BufferedReader in;
    private static BufferedWriter out;
    private boolean isOpen;
    private static int port;
    private String nickname;
    private String password;
    private String access;
    private int mode;
    private HashMap<Integer, String> parameterQuestions = new HashMap<>();

    Connector() {
        tryOfConnect();
    }

    public void tryOfConnect() {
        initialiseParameterQuestions(); //заполнение map вопросами для ввода
        Scanner scanner = new Scanner(System.in);
        boolean tryONeMoreTime = true;
        while (tryONeMoreTime) {
            try {
                tryONeMoreTime = false;
                initialConnection(); // инициализация параметров подключения
                enterLogin();
                enterPassword();
                acceptAccess();
                informationExchange();
            } catch (IOException e) {
                tryONeMoreTime = true;
                System.out.println("Подключиться к серверу не удалось, введите любой символ для повторного подключения");
                scanner.next();
            }
        }
    }

    public void initialConnection() throws IOException {
        clientSocket = new Socket("localhost", port);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        isOpen = true;
    }

    public void enterLogin() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            int accountExist = 0;
            System.out.println("Введите имя пользователя: ");
            nickname = scanner.next();
            out.write(nickname + "\n");
            out.flush();
            accountExist = in.read();
            if (accountExist == 1) {
                break;
            } else {
                System.out.println("Такого пользователя не существует");
            }
        } while (true);
    }

    public void enterPassword() throws IOException {
        Scanner scanner = new Scanner(System.in);
        do {
            int isPasswordCorrect = 0;
            System.out.println("Введите пароль: ");
            password = scanner.next();
            out.write(password + "\n");
            out.flush();
            isPasswordCorrect = in.read();
            if (isPasswordCorrect == 1) {
                System.out.println("Добро пожаловать, " + nickname);
                break;
            } else {
                System.out.println("Пароль не верен");
            }
        } while (true);
    }

    public void acceptAccess() throws IOException {
        access = in.readLine();
    }

    public void informationExchange() {
        while (isOpen) {
            try {
                changeMode();
                switch (mode) {
                    case 1:
                        readCases();
                        break;
                    case 2:
                        changeCases();
                        break;
                    case 3:
                        createNewCase();
                        break;
                }
            } catch (IOException se) {
                closeSocket();
            }
        }
    }

    public void sendMode() throws IOException {
        out.write(mode);
        out.flush();
    }

    public void readCases() throws IOException {
        while (true) {
            int studentListLength = acceptAndShowListOfItems(); //получение количества элементов
            int index = selectItem(studentListLength);
            if (index == -1) {
                break;
            }
            int allParametersSize = in.read();
            System.out.println();
            for (int i = 0; i < allParametersSize; i++) {
                System.out.println((i + 1) + in.readLine());
            }
            System.out.println();
        }
    }

    public void changeCases() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int index = 0; // индекс элемента в списке
        while (true) {
            int studentListLength = acceptAndShowListOfItems(); // получение количества студентов
            index = selectItem(studentListLength); //выбрать студента
            if (index == -1) {
                break;
            }
            while (true) {
                System.out.println();
                int allParametersSize = acceptAndShowListOfItems(); //получение списка параметров студента
                index = selectItem(allParametersSize); //выбрать параметр для изменения
                if (index == -1) {
                    break;
                }
                System.out.println("Введите новый параметр: ");
                String newParameter;
                do {
                    newParameter = scanner.nextLine(); //проверка на пустую строку
                    if(!newParameter.isEmpty()){
                        break;
                    }
                    System.out.println("Введите не пустую строку: ");
                } while (true);
                out.write(newParameter + "\n");
                out.flush();
            }
        }
    }

    public void createNewCase() throws IOException {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < parameterQuestions.size(); i++) {
            System.out.println(parameterQuestions.get(i));
            String parameter;
            do {
                parameter = scanner.nextLine(); //проверка на пустую строку
                if(!parameter.isEmpty()){
                    break;
                }
                System.out.println("Введите не пустую строку: ");
            } while (true);
            out.write(parameter + "\n");
            out.flush();
        }
    }

    public int acceptAndShowListOfItems() throws IOException {
        int listOfItemsLength = in.read();
        for (int i = 0; i < listOfItemsLength; i++) {
            System.out.println((i + 1) + in.readLine());
        }
        return listOfItemsLength;
    }

    public int selectItem(int listOfItemsLength) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int index;
        do {
            System.out.println();
            do { //                           ввод индекса
                System.out.println("Введите номер элемента или введите 0 для перехода в предыдущее меню");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                index = scanner.nextInt();
            } while (index < 0 || index > listOfItemsLength);
            index--;
            if ((index >= 0 && index < listOfItemsLength) || index == -1) {
                out.write(index);
                out.flush();
                break;
            } else {
                System.out.println("такого элемента не существует");
            }
        } while (true);
        return index;
    }

    public static void setPort(int port) {
        Connector.port = port;
    }

    public void closeSocket() {
        try {
            Scanner scanner = new Scanner(System.in);
            isOpen = false;
            System.out.println("Завершение работы");
            clientSocket.close();
            in.close();
            out.close();
            int a = scanner.nextInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeMode() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Режим просмотра дел");
        System.out.println("2. Режим изменения дел");
        System.out.println("3. Создать студенческое дело");
        int key = 0;
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
            do {
                if (access.equals("user") && key > 1 && key < 4) {
                    System.out.println("У вас нет доступа к этой операции. Выберите другой пункт меню: ");
                    key = scanner.nextInt();
                } else {
                    break;
                }
            } while (true);
        } while (key <= 0 || key >= 4);
        mode = key;
        sendMode();
    }

    public void initialiseParameterQuestions() {
        parameterQuestions.put(0, "Введите фамилию: ");
        parameterQuestions.put(1, "Введите имя: ");
        parameterQuestions.put(2, "Введите отчество: ");
        parameterQuestions.put(3, "Введите факультет: ");
        parameterQuestions.put(4, "Введите специальность: ");
        parameterQuestions.put(5, "Введите группу: ");
        parameterQuestions.put(6, "Введите форму обучения: ");
        parameterQuestions.put(7, "Введите форму оплаты: ");
        parameterQuestions.put(8, "Введите льготы: ");
        parameterQuestions.put(9, "Введите семейное положение: ");
        parameterQuestions.put(10, "Введите достижения: ");
    }
}

