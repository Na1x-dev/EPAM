package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notes {
    private ArrayList<Note> notes = new ArrayList<>();
    private File fileOfNotes = new File("notes.txt");
    private String textOfNotes = "";
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;

    Notes() {
        try {
            fileInputStream = new FileInputStream(fileOfNotes);

            int i;
            while ((i = fileInputStream.read()) != -1) {

                textOfNotes = textOfNotes + (char) i;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        findNotesInFile();

    }

    public void print(){
        for(Note note : notes){
            note.print();
        }
    }

    public void updateNotes(){
        textOfNotes = "";
        for(Note note : notes){
            String buf = note.compileNote();
            textOfNotes += buf;
        }
    }

    public void addNewNote(){
        notes.add(new Note());
        updateNotes();
    }

    public void findNotesInFile(){
        Pattern pattern = Pattern.compile("\\{.*\\}");
        Matcher matcher = pattern.matcher(this.textOfNotes);
        while(matcher.find()) {
            notes.add(new Note(matcher.group()));
        }
        updateNotes();

    }

    public void findNotesOnParameter(){
        Scanner scanner = new Scanner(System.in);
        int key;
        System.out.println("1. Найти по теме");
        System.out.println("2. Найти по дате");
        System.out.println("3. Найти по имейлу");
        System.out.println("4. Найти по сообщению");
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >= 5);
        switch (key){
            case 1:
                findOnTheme();
                break;
            case 2:
                findOnDate();
                break;
            case 3:
                findOnEmail();
                break;
            case 4:
                findOnMessage();
                break;
        }


    }

    public void findOnTheme(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите тему: ");
        String theme = scanner.nextLine();
        for(Note note : notes){
            if(note.getTheme().equals(theme)){
                note.print();
            }
        }
    }

    public void findOnDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату: ");
        String date = scanner.nextLine();
        for(Note note : notes){
            if(note.getDate().equals(date)){
                note.print();
            }
        }
    }

    public void findOnEmail(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имейл: ");
        String email = scanner.nextLine();
        for(Note note : notes){
            if(note.getEmail().equals(email)){
                note.print();
            }
        }
    }

    public void findOnMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сообщение: ");
        String message = scanner.nextLine();
        for(Note note : notes){
            if(note.getMessage().equals(message)){
                note.print();
            }
        }
    }

    public void save(){
        try {
            fileOutputStream = new FileOutputStream(fileOfNotes);
            fileOutputStream.write(textOfNotes.getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
