package com.budgetapplication.model;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;


public class UsersTest {

    @Test
    void readUsers_validateFile() throws IOException {
        Users.readUsers();
        Users.setActiveUser("tlgStudent");
        assertEquals("tlgStudent", Users.getActiveUser().getUserLogin());
        assertEquals("password1", Users.getActiveUser().getPassword());
        assertEquals(123, Users.getActiveUser().getBankId());
    }

    @Test
    void readUsers_invalidUser() throws IOException {
        Users.readUsers();
        try {
            Users.setActiveUser("user1");
        } catch (NoSuchElementException e) {
            System.out.println("Inputted active user is not in users-info");
        }
    }

    @Test
    void find_valid() throws IOException {
        Users.readUsers();
        assertTrue(Users.find("tlgStudent", "password1"));
    }

    @Test
    void find_invalid() throws IOException {
        Users.readUsers();
        assertFalse(Users.find("test1", "password1"));
    }

}