package com.company;

import java.util.Scanner;

//9. Даны числа X, Y, Z, Т — длины сторон четырехугольника. Написать метод(методы) вычисления его площади,
//если угол между сторонами длиной X и Y— прямой.

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длины стороны Х четырехугольника: ");
        int X = scanner.nextInt();
        System.out.println("Введите длины стороны Y четырехугольника: ");
        int Y = scanner.nextInt();
        System.out.println("Введите длины стороны Z четырехугольника: ");
        int Z = scanner.nextInt();
        System.out.println("Введите длины стороны T четырехугольника: ");
        int T = scanner.nextInt();
        System.out.println("Площадь четырехугольника равна: " + rectS(X, Y, Z, T));
    }

    public static double rectS(int X, int Y, int Z, int T) {
        double S;
        double gip = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
        double p = (gip + (double) Z + (double) T) / 2;
        S = ((double) X + (double) Y) / 2;
        S = S + Math.sqrt(p * (p - gip) * (p - (double) Z) * (p - (double) T));
        return S;
    }
}
