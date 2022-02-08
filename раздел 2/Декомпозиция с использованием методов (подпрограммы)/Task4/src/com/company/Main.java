package com.company;

import java.util.Scanner;

//4. На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие, между какими
//из пар точек самое большое расстояние. Указание. Координаты точек занести в массив.

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите количество точек: ");
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] X = new int[N];
        int[] Y = new int[N];
        int[] res;
        for(int i=0; i<N; i++)
        {
            X[i] = (int) (Math.random() * 89 + 10);
            Y[i] = (int) (Math.random() * 89 + 10);
            System.out.print("p" + i + "(" + X[i] + ";" + Y[i] + "),  ");
        }
        System.out.println();
        res = getFurthestPoint(X, Y);
        System.out.print("Пара точек, между которыми наибольшее расстояние: " + "p" + res[0] + "(" + X[res[0]] + ";" + Y[res[0]] + ") и " + "p" + res[1] + "(" + X[res[1]] + ";" + Y[res[1]] + ")");
        System.out.println();
    }

    public static int[] getFurthestPoint(int[] X, int[] Y){
        int[] res = new int[2];
        int max=0;
        for(int i=0; i<X.length; i++) {
            for (int j = 0; i < X.length; i++) {
                if (((int) Math.sqrt(Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2))) > max) {
                    max = (int) Math.sqrt(Math.pow(X[i] - X[j], 2) + Math.pow(Y[i] - Y[j], 2));
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
    }
}
