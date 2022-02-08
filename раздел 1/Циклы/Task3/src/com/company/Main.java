package com.company;

//3. Найти сумму квадратов первых ста чисел.

public class Main {

    public static void main(String[] args) {
        int n = 100, sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i * i;
        }
        System.out.println("Сумма квадратов первых ста чисел: " + sum);
    }
}
