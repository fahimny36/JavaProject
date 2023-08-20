package com.project1;

public class Product {
    private int productId;
    private String productName;
    private double sellingPrice;
    private double buyingPrice;
    private int availableQuantity;
    private String category;

    public Product(int productId, String productName, double sellingPrice, double buyingPrice, int availableQuantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.sellingPrice = sellingPrice;
        this.buyingPrice = buyingPrice;
        this.availableQuantity = availableQuantity;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public String getCategory() {
        return category;
    }
}
