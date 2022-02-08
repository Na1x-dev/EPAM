package com.company;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {
    private Library library = new Library();
    private User user = new User();
    private int ELEMENTS_ON_PAGE = 3;

    Menu() {
        login();
        runMenu();
    }

    private void runMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Просмотреть книги");
            System.out.println("2. Найти книгу по названию");
            System.out.println("3. Добавить новую книгу");
            System.out.println("4. Удалить книгу");
            System.out.println("5. Просмотреть почту (" + getCountOfUnread() + ")");
            int key = 0;
            do {
                System.out.println("Введите пункт меню: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                key = scanner.nextInt();
            } while (key <= 0 || key >= 6);
            switch (key) {
                case 1:
                    showTheBooks();
                    break;
                case 2:
                    findBookByName();
                    break;
                case 3:
                    addNewBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    checkEmail();
                    break;
            }
        }
    }

    private void login() {
        Scanner scanner = new Scanner(System.in);
        Users.initEmails();
        while (true) {
            System.out.println("Введите логин: ");
            String username = scanner.next().trim();
            this.user = Users.findUserByUsername(username);
            if (!user.getUsername().equals("")) { //если такой пользователь существует, то продолжить вход
                break;
            }
            System.out.println("Такого пользователя не существует, попробуйте еще раз...");
        }
        while (true) {
            System.out.println("Введите пароль: ");
            String password = scanner.next().trim();
            if (Users.comparePassword(password, this.user)) {
                break;
            }
            System.out.println("Не верный пароль, попробуйте еще раз...");
        }
    }

    private void showTheBooks() {
        Scanner scanner = new Scanner(System.in);
        int key = 1;
        int pageNumber = 0;
        while (key != 0) {
            showPageWithBooks(pageNumber);
            System.out.println("Выберите пункт меню: ");
            System.out.println("1. Следующая страница");
            System.out.println("2. Предыдущая страница");
            System.out.println("3. В главное меню");
            do {
                System.out.println("Введите пункт меню: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                key = scanner.nextInt();
            } while (key <= 0 || key >= 4);
            switch (key) {
                case 1:
                    pageNumber++;
                    if (pageNumber > (int) ((library.getBooks().size() - 1) / (double) ELEMENTS_ON_PAGE))
                        pageNumber = 0;
                    break;
                case 2:
                    pageNumber--;
                    if (pageNumber < 0)
                        pageNumber = (int) ((library.getBooks().size() - 1) / (double) ELEMENTS_ON_PAGE);
                    break;
                case 3:
                    key = 0;
                    break;
            }
        }
    }
    //bookName: ; bookAuthor: ; bookPublishing: ; yearOfPublishing: ; bookType: ;

    private void showPageWithBooks(int pageNumber) {
        System.out.println("Страница " + (pageNumber + 1));
        for (int i = pageNumber * ELEMENTS_ON_PAGE; i < pageNumber * ELEMENTS_ON_PAGE + ELEMENTS_ON_PAGE; i++) {
            if (i < library.getBooks().size()) {
                Book book = library.getBooks().get(i);
                System.out.println("    Книга \"" + book.getBookName() + "\"");
                System.out.println("        Автор: " + book.getBookAuthor());
                System.out.println("        Издательство: " + book.getBookPublishing());
                System.out.println("        Год издательства: " + book.getYearOfPublishing());
                System.out.println("        Тип носителя: " + book.getBookType());
            }
        }
    }

    public void addNewBook() {
        if (user.getRole().equals("admin")) {
            addBookAsAdmin();
        } else {
            addBookAsUser();
        }
    }

    private void addBookAsAdmin() {
        Book book = enterNewBook();
        library.addBook(book);
        sendNotification(book);
    }

    private void addBookAsUser() {
        System.out.println("У вас нет прав редактировать библиотеку, но вы можете отправить книгу на рассмотрение администратору: ");
        Book book = enterNewBook();
        sendSuggestionToAddBook(book);
    }

    private Book enterNewBook() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        System.out.println("Введите название книги: ");
        book.setBookName(scanner.nextLine().trim());
        System.out.println("Введите автора книги: ");
        book.setBookAuthor(scanner.nextLine().trim());
        System.out.println("Введите издательство книги: ");
        book.setBookPublishing(scanner.nextLine().trim());
        System.out.println("Введите год издания книги: ");
        book.setYearOfPublishing(scanner.nextLine().trim());
        System.out.println("Введите тип книги: ");
        book.setBookType(scanner.nextLine().trim());
        return book;
    }

    public void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        int key;
        if (user.getRole().equals("admin")) {
            List<Book> foundBooks = findBookByName();
            showBooks(foundBooks);
            do {
                System.out.println("Введите номер книги или введите 0 для выхода в меню: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                key = scanner.nextInt();
            } while (key <= -1 || key >= foundBooks.size() + 1);
            if (key != 0)
                library.deleteBook(foundBooks.get(key - 1));
        } else {
            System.out.println("У вас нет прав для этих действий");
        }
    }

    private List<Book> findBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название книги: ");
        return library.findBooks(scanner.nextLine().trim());
    }

    private void showBooks(List<Book> foundBooks) {
        int i = 1;
        for (Book book : foundBooks) {
            System.out.println(i + ". Книга \"" + book.getBookName() + "\"");
            System.out.println("    Автор: " + book.getBookAuthor());
            System.out.println("    Издательство: " + book.getBookPublishing());
            System.out.println("    Год издательства: " + book.getYearOfPublishing());
            System.out.println("    Тип носителя: " + book.getBookType());
            i++;
        }
    }

    private void sendNotification(Book book) { //отправить уведомление о новой книге
        for (User user : Users.getAccountsList()) {
            if (!user.getRole().equals("admin")) {
                Email email = new Email(user);
                email.createNotificationLetter(book);
            }
        }
    }

    private void checkEmail() {
        Scanner scanner = new Scanner(System.in);
        int letterNumber = 1;
        Email email = new Email(user);
        while (letterNumber != 0) { // i==0 - выход из меню выбора письма
            letterNumber = 1;
            System.out.println("Список ваших писем, введите число, соответствующее номеру письма, чтобы прочесть его или введите 0 для выхода в главное меню");
            for (Letter letter : email.getLetters()) {
                String readStatus = letter.getReadStatus() ? "прочитано" : "не прочитано";
                System.out.println(letterNumber + ". " + letter.getLetterText() + letter.getBook().getBookName() + "; " + readStatus);
                letterNumber++;
            }
            do {
                System.out.println("Введите номер письма: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("ВВЕДИТЕ ЧИСЛО!");
                    scanner.next();
                }
                letterNumber = scanner.nextInt();
            } while (letterNumber <= -1 || letterNumber >= email.getLetters().size() + 1);
            if (letterNumber != 0) {
                showLetter(letterNumber, email);
            }
        }
    }

    private void showLetter(int letterNumber, Email email) {
        Scanner scanner = new Scanner(System.in);
        Letter letter = email.getLetters().get(letterNumber - 1);
        Book book = letter.getBook();
        System.out.println(letter.getLetterText());
        String readStatus = letter.getReadStatus() ? "прочитано" : "не прочитано";
        System.out.println("Книга \"" + book.getBookName() + "\"");
        System.out.println("    Автор: " + book.getBookAuthor());
        System.out.println("    Издательство: " + book.getBookPublishing());
        System.out.println("    Год издательства: " + book.getYearOfPublishing());
        System.out.println("    Тип носителя: " + book.getBookType());
        System.out.println("Статус: " + readStatus);
        if (!user.getRole().equals("admin") || (user.getRole().equals("admin") && letter.getReadStatus())) {
            System.out.println("Введите любой символ, чтобы закрыть письмо");
            email.getLetters().get(letterNumber - 1).setReadStatus(true);
            email.saveLettersInFile();
            scanner.next();
        } else {
            letterMenu(letterNumber, book, email);
        }
    }

    private int getCountOfUnread() {
        int count = 0;
        Email email = new Email(user);
        for (Letter letter : email.getLetters()) {
            if (!letter.getReadStatus()) {
                count++;
            }
        }
        return count;
    }

    private void sendSuggestionToAddBook(Book book) {
        for (User user : Users.getAccountsList()) {
            if (user.getRole().equals("admin")) {
                Email email = new Email(user);
                email.createSuggestionLetter(book);
                break;
            }
        }
    }

    private void letterMenu(int letterNumber, Book book, Email email) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню: ");
        System.out.println("1. Добавить книгу");
        System.out.println("2. Отклонить книгу");
        System.out.println("3. Закрыть письмо непрочитанным");
        int key = 0;
        do {
            System.out.println("Введите пункт меню: ");
            while (!scanner.hasNextInt()) {
                System.out.println("ВВЕДИТЕ ЧИСЛО!");
                scanner.next();
            }
            key = scanner.nextInt();
        } while (key <= 0 || key >= 4);
        switch (key) {
            case 1:
                library.addBook(book);
                email.getLetters().get(letterNumber - 1).setReadStatus(true);
                sendNotification(book); // оповещает о новой книге в библиотеке
                System.out.println("Предложенная книга успешно добавлена");
                System.out.println(letterNumber-1);
                break;
            case 2:
                email.getLetters().get(letterNumber - 1).setReadStatus(true);
                System.out.println("Предложенная книга отклонена");
                break;
            case 3:
                break;
        }
        email.saveLettersInFile();
        System.out.println("her");
    }
}
