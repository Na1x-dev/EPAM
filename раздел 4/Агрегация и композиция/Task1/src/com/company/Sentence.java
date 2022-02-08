package com.company;
import java.util.ArrayList;

public class Sentence {
    private ArrayList<Word> sentence = new ArrayList<>();

    Sentence(String sentence) {
        String[] words = sentence.split(" ");
        for (String s : words) {
            this.sentence.add(new Word(s));
        }
    }

    public void print() {
        for (int i = 0; i < sentence.size(); i++) {
            sentence.get(i).print();
            if (i < sentence.size() - 1)
                System.out.print(" ");
        }
    }
}
