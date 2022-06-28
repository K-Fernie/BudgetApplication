package com.budgetapplication.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {
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