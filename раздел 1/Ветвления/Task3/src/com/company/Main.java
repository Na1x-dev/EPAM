package com.company;

import java.util.Scanner;

public class Main {

    //3. Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1, y1, x2, y2, x3, y3, buf;
        System.out.println("Введите х первой точки");
        x1 = scanner.nextInt();
        System.out.println("Введите у первой точки");
        y1 = scanner.nextInt();
        System.out.println("Введите х второй точки");
        x2 = scanner.nextInt();
        System.out.println("Введите у второй точки");
        y2 = scanner.nextInt();
        System.out.println("Введите х третьей точки");
        x3 = scanner.nextInt();
        System.out.println("Введите у третьей точки");
        y3 = scanner.nextInt();
        buf = (x3 * (y2 - y1) - x1 * (y2 - y1) + y1 * (y2 - y1)) / (x2 - x1);
        if (buf == y3)
            System.out.println("Точки принадлежат прямой.");
        else
            System.out.println("Точки не принадлежат прямой.");
    }
}
