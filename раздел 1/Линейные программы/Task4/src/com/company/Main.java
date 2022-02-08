package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

//4. Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях). Поменять местами
//дробную и целую части числа и вывести полученное значение числа.

public class Main {

    public static void main(String[] args) {
        double R, z, buf1, buf2;
        DecimalFormat df = new DecimalFormat("###.###");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите данные: ");
            R = scanner.nextDouble();
        } while (!(R < 1000 && R > 99));
        buf1 = R * 1000;
        z = buf1 % 1000;
        buf2 = z % 1;
        z = z - buf2;
        R = (buf1 - z) / 1000000;
        z = z + R;
        System.out.println("Результат: " + df.format(z));
    }
}
