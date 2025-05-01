package com.tns.FoodDeliverySystem.application;



public class Customer extends User {
    private String address;
    private String phoneNumber;
    private Cart cart;

    public Customer(int userId, String name, String email, String password, String address, String phoneNumber) {
        super(userId, name, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.cart = new Cart();
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Cart getCart() {
        return cart;
    }

    public void addItemToCart(FoodItem foodItem, int quantity) {
        cart.addItem(foodItem, quantity);
    }

    public void viewCart() {
        cart.showCartDetails();
    }

    public void clearCart() {
        cart.clearCart();
    }
}

