package com.project1.services;


import com.project1.Product;
import com.project1.dao.Item;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerServices {
    private List<Product> products;
    private List<Item> items;
    private Map<String, Integer> customerSuperCoins;
    private Scanner scanner;

    public CustomerServices(List<Item> items) {
        this.items = items;
        products = new ArrayList<>();
        customerSuperCoins = new HashMap<>();
        scanner = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            double buyingPrice = new Random().nextDouble() * 100;
            double sellingPrice = (buyingPrice * 0.5) + buyingPrice;
            products.add(new Product(i, "Product " + i, sellingPrice, buyingPrice, new Random().nextInt(50), "Category " + (i % 4 + 1)));
        }
    }

    public void customerLogin() throws InvalidInputException {
        System.out.println("Enter your customer ID: ");
        int customerId = readIntegerInput();
        scanner.nextLine(); // Consume the newline character

        if (customerSuperCoins.containsKey(String.valueOf(customerId))) {
            System.out.println("Welcome back! You have " + customerSuperCoins.get(String.valueOf(customerId)) + " super coins.");
        } else {
            System.out.println("Welcome new customer! You have been awarded 100 super coins.");
            customerSuperCoins.put(String.valueOf(customerId), 100);
        }

        displayProducts();
    }

    public void customerRegistration() throws InvalidInputException {
        System.out.println("Enter your new customer ID: ");
        int customerId = readIntegerInput();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Registration successful! You have been awarded 100 super coins.");
        customerSuperCoins.put(String.valueOf(customerId), 100);

        displayProducts();
    }

    public void displayProducts() {
        System.out.println("Available products:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
            System.out.println("---------------");
        }
    }

    public void applyFilters() {
        System.out.println("Choose filter option:");
        System.out.println("1. Filter by category");
        System.out.println("2. Filter by price");

        int filterChoice = 0;
        try {
            filterChoice = readIntegerInput();
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        scanner.nextLine(); // Consume the newline character

        if (filterChoice == 1) {
            System.out.println("Enter category to filter:");
            String category = scanner.nextLine();

            List<Product> filteredProducts = products.stream()
                    .filter(product -> product.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());

            displayFilteredProducts(filteredProducts);
        } else if (filterChoice == 2) {
            List<Product> sortedProducts = products.stream()
                    .sorted(Comparator.comparingDouble(Product::getSellingPrice))
                    .collect(Collectors.toList());

            displayFilteredProducts(sortedProducts);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public void displayFilteredProducts(List<Product> filteredProducts) {
        System.out.println("Filtered products:");
        for (Product product : filteredProducts) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
            System.out.println("---------------");
        }
    }

    public int readIntegerInput() throws InvalidInputException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InvalidInputException("Invalid input. Please enter a valid integer.");
        } finally {
            scanner.nextLine(); // Consume the newline character
        }
    }

    public void runMenu() {
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("Customer Services Menu:");
                System.out.println("1. Existing customer login");
                System.out.println("2. New customer registration");
                System.out.println("3. Apply filters");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = readIntegerInput();

                switch (choice) {
                    case 1:
                        customerLogin();
                        break;
                    case 2:
                        customerRegistration();
                        break;
                    case 3:
                        applyFilters();
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option");
                }
            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", "Category 1", 50));
        items.add(new Item("Item 2", "Category 2", 60));
        items.add(new Item("Item 3", "Category 1", 45));
        items.add(new Item("Item 4", "Category 3", 30));

        List<Thread> userThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) { // Start threads for 5 different users
            Thread userThread = new Thread(() -> {
                CustomerServices customerServices = new CustomerServices(items);
                customerServices.runMenu();
            });
            userThreads.add(userThread);
            userThread.start();
        }

        // Wait for all user threads to complete
        for (Thread userThread : userThreads) {
            try {
                userThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All users have completed.");
    }
}
