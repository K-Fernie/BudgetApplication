package com.budgetapplication.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Users is a utility class that's used to read and write into the
 * associated csv files. It contains a static observable list that holds
 * all the users that can log in. The list is used to check
 * log in with the user interface.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class Users {
    private static List<User> users;
    private static User activeUser;

    /**
     * This method is used to read the user-info.csv file from the resource
     * folder. It uses Buffer Reader with an Input file stream. The file data are
     * separated by a comma delimiter. The input stream is stored into a
     * static Observable list of users that will be verified during log in access.
     * @throws IOException
     */
    public static synchronized void readUsers() throws IOException {
        if (null == users) {
            users = new ArrayList<User>();
            String file = "src/main/resources/com.budgetapplication.file/user-info.csv";
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    String[] tokens = line.split(",");
                    users.add(new User(Integer.parseInt(tokens[0]), tokens[1], tokens[2]));
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("There was an issue reading the file.");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                throw new NumberFormatException("The formatting for the wrapper classes were not done properly.");
            }
        }
    }

    /**
     * This method is used to find the current user information implemented during
     * the log in screen. This will verify their username and password for access
     * to the application.
     * @param username - username set during login screen
     * @param password - password set during login screen
     * @return true/false - users stream will determine if the password and username exists in combo.
     */
    public static synchronized boolean find(String username, String password) {
        if (null == users) {
            throw new IllegalStateException("user list is not initialised");
        }
        return users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .anyMatch((u) -> u.getPassword().equals(password));
    }

    /**
     * This method will set the current user as the active user. The
     * active user can be used as a reference to know which user
     * is currently using the application.
     * @param username - the username verified during login
     */
    public static synchronized void setActiveUser(String username) {
        activeUser = users.stream()
                .filter((u) -> u.getUserLogin().equals(username))
                .findFirst()
                .get();

    }

    public static synchronized User getActiveUser(){
        return activeUser;
    }

}
