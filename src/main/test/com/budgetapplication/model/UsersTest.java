package com.budgetapplication.model;

import org.testng.annotations.Test;
import java.io.IOException;


public class UsersTest {
    @Test
    void readUsers_validateFile() throws IOException {
        Users.readUsers();
    }

    @Test
    void find_validateSearch() throws IOException {
        boolean foundUser = false;
        Users.readUsers();
        foundUser = Users.find("tlgStudent", "password1");
        System.out.println("User Found: " + foundUser);
    }

}