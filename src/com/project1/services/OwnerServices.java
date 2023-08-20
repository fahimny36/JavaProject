package com.project1.services;

import com.project1.Product;
import com.project1.dao.Item;

import java.util.*;
import java.util.stream.Collectors;

public class OwnerServices {
    private List<Product> products;
    private List<Item> items;
    private Scanner scanner;

    public OwnerServices(List<Item> items) {
        this.items = items;
        products = new ArrayList<>();
        // Adding some initial random products
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            double buyingPrice = random.nextDouble() * 100;
            double sellingPrice = (buyingPrice * 0.5) + buyingPrice;
            products.add(new Product(i, "Product " + i, sellingPrice, buyingPrice, random.nextInt(50), "Category " + (i % 4 + 1)));
        }

        scanner = new Scanner(System.in);
    }

    public void listProducts() {
        System.out.println("Products in the store:");
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
            System.out.println("---------------");
        }
    }

    public void searchProductById() {
        System.out.print("Enter Product ID to search: ");
        int productId = scanner.nextInt();

        Optional<Product> foundProduct = products.stream()
                .filter(product -> product.getProductId() == productId)
                .findFirst();

        if (foundProduct.isPresent()) {
            Product product = foundProduct.get();
            System.out.println("Product found:");
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }

    public void listProductsByCategory(String category) {
        System.out.println("Products in the " + category + " category:");
        List<Product> productsInCategory = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        for (Product product : productsInCategory) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
            System.out.println("---------------");
        }
    }

    public void searchProductByName(String name) {
        System.out.println("Products with name '" + name + "':");
        List<Product> productsWithName = products.stream()
                .filter(product -> product.getProductName().equalsIgnoreCase(name))
                .collect(Collectors.toList());

        for (Product product : productsWithName) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Selling Price: " + product.getSellingPrice());
            System.out.println("Available Quantity: " + product.getAvailableQuantity());
            System.out.println("---------------");
        }
    }

    public void calculateTotalAmountSpent() {
        double totalAmount = products.stream()
                .mapToDouble(product -> product.getSellingPrice() * product.getAvailableQuantity())
                .sum();

        System.out.println("Total amount spent on products: " + totalAmount);
    }

    public void displayProfitByCategory() {
        Map<String, Double> profitByCategory = new HashMap<>();
        for (Product product : products) {
            profitByCategory.putIfAbsent(product.getCategory(), 0.0);
            profitByCategory.put(product.getCategory(),
                    profitByCategory.get(product.getCategory()) +
                            (product.getSellingPrice() - product.getBuyingPrice()) * product.getAvailableQuantity());
        }

        System.out.println("Profit amount by category:");
        for (Map.Entry<String, Double> entry : profitByCategory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void addNewProduct() {
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Buying Price: ");
        double buyingPrice = scanner.nextDouble();

        System.out.print("Enter Available Quantity: ");
        int availableQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        double sellingPrice = (buyingPrice * 0.5) + buyingPrice;
        int productId = products.size() + 1;

        products.add(new Product(productId, productName, sellingPrice, buyingPrice, availableQuantity, category));
        System.out.println("New product added successfully.");
    }


    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", "Category 1", 50));
        items.add(new Item("Item 2", "Category 2", 60));
        items.add(new Item("Item 3", "Category 1", 45));
        items.add(new Item("Item 4", "Category 3", 30));

        OwnerServices owner = new OwnerServices(items);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("Owner Services Menu:");
            System.out.println("1. List Products");
            System.out.println("2. Search Product by ID");
            System.out.println("3. List Products by Category");
            System.out.println("4. Search Product by Name");
            System.out.println("5. Calculate Total Amount Spent");
            System.out.println("6. Display Profit by Category");
            System.out.println("7. Add New Product");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    owner.listProducts();
                    break;
                case 2:
                    owner.searchProductById();
                    break;
                case 3:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    owner.listProductsByCategory(category);
                    break;
                case 4:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    owner.searchProductByName(productName);
                    break;
                case 5:
                    owner.calculateTotalAmountSpent();
                    break;
                case 6:
                    owner.displayProfitByCategory();
                    break;
                case 7:
                    owner.addNewProduct();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        }

    }
}