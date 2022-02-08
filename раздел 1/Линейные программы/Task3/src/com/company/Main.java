package com.company;

import java.util.Scanner;

//3. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
//

public class Main {

    public static void main(String[] args) {
        double x, y, z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите x: ");
        x = scanner.nextFloat();
        System.out.println("Введите y: ");
        y = scanner.nextFloat();
        z = ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);
        System.out.println("z = " + z);
    }
}
