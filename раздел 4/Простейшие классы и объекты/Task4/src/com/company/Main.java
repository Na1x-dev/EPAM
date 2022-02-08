package com.company;

import java.util.*;

//4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отправления.
//Создайте данные в массив из пяти элементов типа Train, добавьте возможность сортировки элементов массива по
//номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
//Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми пунктами
//назначения должны быть упорядочены по времени отправления.

class Train {
    String destination;
    int trainNumber;
    String departureTime;

    Train(String destination, int trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public void show() {
        System.out.println("  - Пункт назначения поезда: " + destination);
        System.out.println("    Номер поезда: " + trainNumber);
        System.out.println("    Время отправления поезда: " + departureTime);
    }
}

public class Main {

    public static void sortByNumber(ArrayList<Train> arrTrain) {
        Collections.sort(arrTrain, new Comparator<Train>() {
            public int compare(Train t1, Train t2) {
                return t1.trainNumber - t2.trainNumber;
            }
        });
    }

    public static void findTrain(ArrayList<Train> arrTrain) {
        while (true) {
            System.out.println("Введите номер поезда: ");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            boolean isExist = false;
            for (Train t : arrTrain) {
                if (number == t.trainNumber) {
                    System.out.println("  - Пункт назначения поезда: " + t.destination);
                    System.out.println("    Время отправления поезда: " + t.departureTime);
                    isExist = true;
                }
            }
            if (!isExist) {
                System.out.println("    поезда с таким номером не существует");
            }
            else {
                break;
            }
        }
    }

    public static void sortByDestination(ArrayList<Train> arrTrain) {
        Collections.sort(arrTrain, new Comparator<Train>() {
            public int compare(Train t1, Train t2) {
                return t1.departureTime.compareTo(t2.departureTime);
            }
        });

        Collections.sort(arrTrain, new Comparator<Train>() {
            public int compare(Train t1, Train t2) {
                return t1.destination.compareTo(t2.destination);
            }
        });
    }

    public static void main(String[] args) {
        ArrayList<Train> arrayTrain = new ArrayList<>();
        arrayTrain.add(new Train("Минск пассажирский", 647, "16:48"));
        arrayTrain.add(new Train("Баранчицы полесские", 1464, "21:53"));
        arrayTrain.add(new Train("Береза город", 495, "18:22"));
        arrayTrain.add(new Train("Оранчицы", 424, "15:04"));
        arrayTrain.add(new Train("Оранчицы", 1448, "14:13"));

        System.out.println("Поезда отсортированы по номерам поездов: ");
        sortByNumber(arrayTrain);
        for (Train t : arrayTrain) {
            t.show();
        }

        System.out.println();
        findTrain(arrayTrain);

        System.out.println();
        System.out.println("Поезда отсортированы по пункту назначения: ");
        sortByDestination(arrayTrain);
        for (Train t : arrayTrain) {
            t.show();
        }
    }
}
