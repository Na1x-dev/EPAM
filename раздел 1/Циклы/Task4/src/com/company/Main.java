package com.company;

import java.math.BigInteger;

//4. Составить программу нахождения произведения квадратов первых двухсот чисел.

public class Main {

    public static void main(String[] args) {
        int n = 200;
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf((long) i * i));
        }
        System.out.println("Произведение квадратов первых двухсот чисел: " + res);
    }
}
