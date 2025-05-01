package com.tns.FoodDeliverySystem.application;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private int id;
    private String name;
    private List<FoodItem> menu;

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int foodItemId) {
        menu.removeIf(foodItem -> foodItem.getId() == foodItemId);
    }

    public void showMenu() {
        System.out.println("Menu for " + name);
        for (FoodItem foodItem : menu) {
            System.out.println(foodItem.getName() + " - " + foodItem.getPrice());
        }
    }
}

