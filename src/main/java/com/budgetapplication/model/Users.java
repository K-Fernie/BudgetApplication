package com.budgetapplication.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Users {
    private static List<User> users;
    private static User activeUser;

    public static synchronized void readUsers() throws IOException {
        if (null == users) {
            users = new ArrayList<User>();
            String file = "src/main/resources/com.budgetapplication.file/user-info.csv";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");
                users.add(new User(Integer.parseInt(tokens[0]), tokens[1], tokens[2]));
            }
        }
    }

    public static synchronized boolean find(String username, String password) {
        boolean findUser = false;
        if (null == users) {
            throw new IllegalStateException("user list is not initialised");
        }
        return users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .anyMatch((u) -> u.getPassword().equals(password));
    }

    public static synchronized void setActiveUser(String username) {
        activeUser = users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .findFirst()
                .get();

    }

    public static synchronized User getActiveUser() {
        return activeUser;
    }
}
