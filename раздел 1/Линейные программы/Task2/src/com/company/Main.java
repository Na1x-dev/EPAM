package com.company;

import java.util.Scanner;

//2. Вычислить значение выражения по формуле (все переменные принимают действительные значения):
//

public class Main {

    public static void main(String[] args) {
        double a, b, c, z;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите a: ");
        a = scanner.nextFloat();
        System.out.println("Введите b: ");
        b = scanner.nextFloat();
        System.out.println("Введите c: ");
        c = scanner.nextFloat();
        z = ((b + Math.sqrt(Math.pow(b, 2) + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
        System.out.println("z = " + z);
    }
}
