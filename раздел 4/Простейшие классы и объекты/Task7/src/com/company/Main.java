package com.company;

//7. Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов, вычисления
//площади, периметра и точки пересечения медиан.

import java.util.Scanner;

class Triangle {
    double xA; //координаты точки А
    double yA;

    double xB; //координаты точки В
    double yB;

    double xC; //координаты точки С
    double yC;

    double a; //длина стороны а
    double b; //длина стороны b
    double c; //длина стороны с

    Triangle(){
    }

    Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.xC = xC;
        this.yC = yC;
        findABC();
    }

    public void findABC(){
        this.a = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));
        this.b = Math.sqrt(Math.pow(xB - xC, 2) + Math.pow(yB - yC, 2));
        this.c = Math.sqrt(Math.pow(xC - xA, 2) + Math.pow(yC - yA, 2));
    }

    public double area() {
        double s;
        double p = (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

    public double perimeter() {
        return a + b + c;
    }

    public double[] centerOfGravity() { //центр пересечения медиан
        double xN = (xA + xB) / 2;
        double yN = (yA + yB) / 2;
        double xL = (xA + xC) / 2;
        double yL = (yA + yC) / 2;
        double X = (-1) * ((yB - yC) * (xN - xC) * (xL - xB) - xC * (yN - yC) * (xL - xB) + xB * (yL - yB) * (xN - xC)) / ((xL - xB) * (yN - yC) - (xN - xC) * (yL - yB));
        double Y = ((X - xC) * (yN - yC)) / (xN - xC) + yC;
        return new double[]{X, Y};
    }

    public void setxA(double xA) {
        this.xA = xA;
    }

    public void setxB(double xB) {
        this.xB = xB;
    }

    public void setxC(double xC) {
        this.xC = xC;
    }

    public void setyA(double yA) {
        this.yA = yA;
    }

    public void setyB(double yB) {
        this.yB = yB;
    }

    public void setyC(double yC) {
        this.yC = yC;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle(1, 2, 2, 3, 3, 2);
        printTriangle(triangle);
        while (true) {
            System.out.println("Введите x координату для точки А: ");
            triangle.setxA(scanner.nextDouble());
            System.out.println("Введите y координату для точки А: ");
            triangle.setyA(scanner.nextDouble());
            System.out.println("Введите x координату для точки B: ");
            triangle.setxB(scanner.nextDouble());
            System.out.println("Введите y координату для точки B: ");
            triangle.setyB(scanner.nextDouble());
            System.out.println("Введите x координату для точки C: ");
            triangle.setxC(scanner.nextDouble());
            System.out.println("Введите y координату для точки C: ");
            triangle.setyC(scanner.nextDouble());
            triangle.findABC();
            printTriangle(triangle);
        }
    }

    static void printTriangle(Triangle triangle) {
        double[] cords = triangle.centerOfGravity();
        System.out.println("a = " + triangle.getA() + "; b = " + triangle.getB() + "; c = " + triangle.getC());
        System.out.println("Площадь треугольника: " + triangle.area());
        System.out.println("Периметр треугольника: " + triangle.perimeter());
        System.out.println("Координаты точки пересечения медиан: (" + cords[0] + "; " + cords[1] + ")");
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}
