package com.company;
import java.util.ArrayList;

public class Text {
    private String header;
    public ArrayList<Sentence> text = new ArrayList<>();

    Text(String text) {
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            this.text.add(new Sentence(sentence));
        }
    }

    public void print() {
        for (Sentence sentence : text) {
            sentence.print();
            System.out.print(".");
        }
    }

    public void addSentence(String text) {
        String[] sentences = text.split("\\.");
        for (String sentence : sentences) {
            this.text.add(new Sentence(sentence));
        }
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void printHeader() {
        System.out.println(header);
    }
}
