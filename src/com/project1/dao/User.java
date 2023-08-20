package com.project1.dao;


public class User {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }

    private String username;
    private String emailId;
    private String password;
    private int superCoins;

    public User(String username, String emailId, String password, int superCoins) {
        this.username = username;
        this.emailId = emailId;
        this.password = password;
        this.superCoins = superCoins;
    }
}