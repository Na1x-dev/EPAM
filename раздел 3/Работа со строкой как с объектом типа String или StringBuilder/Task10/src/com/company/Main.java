package com.company;

//10. Строка X состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным или вопросительным
//знаком. Определить количество предложений в строке X.

public class Main {

    public static void main(String[] args) {
        String X = "Food is an important substance for human organism! It mainly consists of proteins, fats and carbohydrates. Besides these three nutritive materials, food can also be nodivided into 2 groups – meals of plant origin and meals of animal origin.";
        System.out.println("Строка: " + X);
        int countOfSentences = 0;
        for (int i = 0; i < X.length(); i++) {
            if (X.charAt(i) == '.' || X.charAt(i) == '!' || X.charAt(i) == '?') {
                countOfSentences++;
            }
        }
        System.out.println("Количество предложений в строке: " + countOfSentences);
    }
}
