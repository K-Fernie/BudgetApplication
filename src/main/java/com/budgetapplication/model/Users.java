package com.budgetapplication.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Users {
    private static List<User> users;
    private static User activeUser;

    /*
    UserId, Name, Password
    1101, HenryR, Dfowjf121
     */
    public static synchronized void readUsers() {
        if (null == users) {
            users = new ArrayList<User>();
            String File = "USERS.csv";
            Scanner scan = new Scanner(Users.class.getResourceAsStream(File));
            String line;
            while ((line = scan.nextLine()) != null) {
                String[] tokens = line.split(",");
                users.add(new User(Integer.parseInt(tokens[0]), tokens[1], tokens[2]));
            }
            scan.close();
        }
    }

    public static synchronized boolean find(String username, String password) {
        boolean findUser = false;
        if (null == users) {
            throw new IllegalStateException("user list is not initialised");
        }

        return users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .filter((u) -> u.getPassword().equals(password))
                .findFirst()
                .isPresent();

    }
    public static synchronized void setActiveUser(String username){
        activeUser = users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .findFirst()
                .get();

    }

    public static synchronized User getActiveUser() {
        return activeUser;
    }
}
