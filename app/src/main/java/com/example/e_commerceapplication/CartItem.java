package com.example.e_commerceapplication;

public class CartItem {
    private String name;
    private double price;

    // Constructor
    public CartItem(String name, double price) {
        this.name = name;
        this.price = price;

    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }



    // Setters (if needed)
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
