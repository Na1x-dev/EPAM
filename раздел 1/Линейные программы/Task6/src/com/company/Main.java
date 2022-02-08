package com.company;

import java.util.Scanner;

//6. Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
//принадлежит закрашенной области, и false — в противном случае:

public class Main {

    public static void main(String[] args) {
        double y1 = 0, y2 = 4, x1 = -2, x2 = 2, y3 = -3, y4 = 0, x3 = -4, x4 = 4, y, x;
        boolean res = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x: ");
        x = scanner.nextDouble();
        System.out.println("Введите y: ");
        y = scanner.nextDouble();
        if ((x >= x1 && y >= y1 && x <= x2 && y <= y2) || (x >= x3 && y >= y3 && x <= x4 && y <= y4))
            res = true;
        System.out.println("Результат: " + res);
    }
}
