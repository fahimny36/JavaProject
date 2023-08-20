package com.project1.dto;

import com.project1.dao.User;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Login {
    private List<User> users;
    private Scanner scanner;

    public Login() {
        users = new ArrayList<>();
        // Adding a dummy store owner user
        users.add(new User("princy", "princy@example.com", "password123", 100)); // Adding superCoins

        scanner = new Scanner(System.in);
    }

    public boolean validateCredentials() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        if (login.validateCredentials()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}