package com.budgetapplication.model;

/**
 * User is a storage class used to hold the information about the
 * current active user. It will also be used to verify the user
 * during login to gain access to the application.
 *
 * @author Daniel, Kaitlyn, Kenneth
 * @version 1.0
 */
public class User {
    private String userLogin;
    private String password;
    private int bankId;

    /**
     * This constructor is the only constructor and has 3
     * parameters.
     * @param bankId - the bank ID associated with the user
     * @param userLogin - the user login name
     * @param password - the user account password
     */
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
