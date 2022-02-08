package com.company;

//3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость (массив
//из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность вывода фамилий и
//номеров групп студентов, имеющих оценки, равные только 9 или 10.

class Student {
    String fullName;
    String group;
    int[] score;

    public Student(String fullName, String group) {
        this.fullName = fullName;
        this.group = group;
        this.score = randomScore();
    }

    public void showIfGoodStudent() {
        boolean goodScore = true;
        for (int i : score) {
            if (i < 9) {
                goodScore = false;
                break;
            }
        }
        if (goodScore) {
            System.out.println("    Студент: " + fullName);
            System.out.println("        Группа: " + group);
        }
    }

    public void showStudent() {
        System.out.println("    Студент: " + fullName);
        System.out.println("        Группа: " + group);
    }

    public int[] randomScore() {
        int[] score = new int[5];
        for (int i = 0; i < score.length; i++) {
            score[i] = 8 + (int) (Math.random() * 3);
        }
        return score;
    }
}

public class Main {

    public static void main(String[] args) {
        Student[] arrayOfStudents = new Student[]{
                new Student("Потворов И.В.", "Э-57"),
                new Student("Огиевич Е.А.", "ПО-3"),
                new Student("Мискевич А.А.", "АС-53"),
                new Student("Афанасьев Д.А.", "Э-57"),
                new Student("Данилюк А.И.", "Э-57"),
                new Student("Попов А.В.", "АС-54"),
                new Student("Иванов И.И.", "ИИ-16"),
                new Student("Пунько В.В.", "П-19"),
                new Student("Мущук Т.В.", "Э-57"),
                new Student("Басик М.Г.", "Э-57"),
        };
        System.out.println("Список студентов: ");
        for (Student student : arrayOfStudents) {
            student.showStudent();
        }
        System.out.println("Список студентов с хорошими оценками: ");
        for (Student student : arrayOfStudents) {
            student.showIfGoodStudent();
        }
    }
}
