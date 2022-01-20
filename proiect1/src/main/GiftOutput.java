package main;

import enums.Category;

public class GiftOutput {
    private String productName;
    private Double price;
    private Category category;

    public GiftOutput(String productName, Double price, Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }
}
