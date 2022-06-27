package com.budgetapplication.model;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String userLogin;
    private String password;
    private int bankId;

    //constructor used to create a new user
    public User(int bankId, String userLogin, String password) {
        this.userLogin = userLogin;
        this.password = password;
        this.bankId  = bankId;
    }

    //TODO query the database for the user, if the user exists do nothing

    public String getUserLogin() {
        return userLogin;
    }

    //TODO query the database for the user, if the user exists do nothing
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getPassword() {
        return password;
    }

    //TODO query the database for the user, if the user exists do nothing
    public void setPassword(String password) {
        this.password = password;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

}
