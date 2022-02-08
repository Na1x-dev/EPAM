package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Дана строка, содержащая следующий текст (xml-документ). Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип (открывающий
//тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML для решения данной задачи
//нельзя.

public class Main {

    public static void main(String[] args) {
        String str = "<notes > \r\n" +
                "   <note id = \"1\"> \r\n" +
                "       <to>Вася</to> \r\n" +
                "       <from>Света</from> \r\n" +
                "       <heading>Напоминание</heading> \r\n" +
                "       <body>Позвони мне завтра!</body> \r\n" +
                "   </note> \r\n" +
                "   <note id = \"2\"> \r\n" +
                "       <to>Петя</to> \r\n" +
                "       <from>Маша</from> \r\n" +
                "       <heading>Важное напоминание</heading> \r\n" +
                "       <body/> \r\n" +
                "   </note> \r\n" +
                "</notes> \r\n";

        System.out.println(xmlParser(str));
    }

    public static String xmlParser(String xml) {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern patternOpenTag = Pattern.compile("<\\w.+?>"); //паттерн открывающего тега
        Pattern patternCloseTag = Pattern.compile("</\\w.+?>"); //паттерн закрывающего тега
        Pattern patternContent = Pattern.compile(">.+?<"); //паттерн содержимого тега
        Pattern patternNoBodyTag = Pattern.compile("<\\w.+?>"); //паттерн тега без тела
        String[] lines = xml.split("\n");
        for (String line : lines) { //проходимся по строкам и находим нужные нам элементы
            Matcher matcherOpenTag = patternOpenTag.matcher(line);
            Matcher matcherCloseTag = patternCloseTag.matcher(line);
            Matcher matcherContent = patternContent.matcher(line);
            Matcher matcherNoBodyTag = patternNoBodyTag.matcher(line);
            if (matcherOpenTag.find()) { //добавляем в конец строки находим открывающий тег с обозначением
                stringBuilder.append(matcherOpenTag.group());
                stringBuilder.append(" - открывающий тег\n");
            }
            if (matcherCloseTag.find()) { //добавляем в конец строки находим закрывающий тег с обозначением
                stringBuilder.append(matcherCloseTag.group());
                stringBuilder.append(" - закрывающий тег\n");
            }
            if (matcherContent.find()) { //добавляем в конец строки находим содержимое тега с обозначением
                stringBuilder.append("«");
                stringBuilder.append(matcherContent.group(), 1, matcherContent.group().length() - 1);
                stringBuilder.append("» - контент\n");
            }
            if (matcherNoBodyTag.find()) { //находим тег без тела
                stringBuilder.append(matcherNoBodyTag.group()); //добавляем в конец строки тег без тела с обозначением
                stringBuilder.append(" - тег без тела\n");
            }
        }
        return stringBuilder.toString(); // возвращаем отчет в виде строки
    }
}
