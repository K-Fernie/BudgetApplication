package com.budgetapplication.model;

import java.util.ArrayList;

public class User {

    private String name;
    private String userLogin;
    private String password;
    private ArrayList<BankAccount> accounts;

    //constructor used to create a new user
    public User(String name, String userLogin, String password, BankAccount acct) {
        this.name = name;
        this.userLogin = userLogin;
        this.password = password;
        accounts.add(acct);
    }

    public String getName() {
        return name;
    }

    //TODO query the database for the user, if the user exists do nothing
    public void setName(String name) {
        this.name = name;
    }

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
}
