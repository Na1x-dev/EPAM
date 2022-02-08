package com.company;

//3. Вычислить площадь правильного шестиугольника со стороной а, используя метод вычисления площади
//треугольника.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите сторону шестиугольника: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("Площадь правильного шестиугольника равна: " + areaHex(a));
    }

    public static int areaHex(int a) {
        return (int) (3 * a * a * Math.sqrt(3)) / 2;
    }
}
