package main;

import enums.Category;

public class GiftOutput {
    private String productName;
    private Double price;
    private Category category;

    public GiftOutput(final String productName, final Double price,
                      final Category category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
    /**
     * Getter for the productName
     */
    public String getProductName() {
        return productName;
    }
    /**
     * Getter for the price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Getter for the category of this gift
     */
    public Category getCategory() {
        return category;
    }
}
