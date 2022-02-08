package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Users {
    private static String ACCOUNTS_PATH = "accounts.txt";

    private static List<String> getAccountsStringList() {
        StringBuilder accountsString = new StringBuilder();
        String[] accountsStringArray;
        List<String> accountsStringList = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream(ACCOUNTS_PATH)) {
            int i = -1;
            while ((i = fin.read()) != -1) {
                accountsString.append((char) i);
            }
            accountsStringArray = accountsString.toString().split("\n");
            accountsStringList = Arrays.asList(accountsStringArray);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return accountsStringList;
    }

    public static List<User> getAccountsList() {
        List<String> accountsStringList = getAccountsStringList();
        List<User> users = new ArrayList<>();
        Pattern usernamePattern = Pattern.compile("username: .+?;");
        Pattern passwordPattern = Pattern.compile("password: .+?;");
        Pattern rolePattern = Pattern.compile("role: .+?;");
        for (int i = 0; i < accountsStringList.size(); i++) {
            User user = new User();
            Matcher usernameMatcher = usernamePattern.matcher(accountsStringList.get(i));
            Matcher passwordMatcher = passwordPattern.matcher(accountsStringList.get(i));
            Matcher roleMatcher = rolePattern.matcher(accountsStringList.get(i));
            while (usernameMatcher.find())
                user.setUsername(usernameMatcher.group().substring(10, usernameMatcher.group().length() - 1));
            while (passwordMatcher.find())
                user.setPassword(passwordMatcher.group().substring(10, passwordMatcher.group().length() - 1));
            while (roleMatcher.find())
                user.setRole(roleMatcher.group().substring(6, roleMatcher.group().length() - 1));
            users.add(user);
        }
        return users;
    }

    public static User findUserByUsername(String username) {
        List<User> users = getAccountsList();
        User mainUser = new User();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                mainUser = user;
            }
        }
        return mainUser;
    }

    public static boolean comparePassword(String password, User mainUser) { //сравнение введенного пароля с настоящим паролем пользователя
        return decryptPassword(mainUser.getPassword()).equals(password);
    }

    public static String decryptPassword(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();
        for(int i = 0; i < encryptedPassword.length(); i++) {
            char sym;
            if (i % 2 == 0) {
                sym = ((char) ((int) encryptedPassword.charAt(i) - 2));
            } else {
                sym = ((char) ((int) encryptedPassword.charAt(i) + 2));
            }
            decryptedPassword.append(sym);
        }
        return decryptedPassword.toString();
    }

    public static void initEmails(){
        List <User> users = getAccountsList();
        for(User user : users){
            Email.initEmailFile(user);
        }
    }

}
