package com.tns.FoodDeliverySystem.application;

import java.util.ArrayList;
import java.util.List;

public class FoodService {
    private List<Restaurant> restaurants = new ArrayList<>();

 // Method to add a restaurant
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Restaurant added: " + restaurant.getName());
    }

    // Method to add a food item to a specific restaurant
    public void addFoodItemToRestaurant(int restaurantId, FoodItem foodItem) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.addFoodItem(foodItem);
                System.out.println("Food item " + foodItem.getName() + " added to restaurant " + restaurant.getName());
                return;
            }
        }
        System.out.println("Restaurant with ID " + restaurantId + " not found.");
    }

    // Method to remove a food item from a specific restaurant
    public void removeFoodItemFromRestaurant(int restaurantId, int foodItemId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                restaurant.removeFoodItem(foodItemId);
                System.out.println("Food item with ID " + foodItemId + " removed from restaurant " + restaurant.getName());
                return;
            }
        }
        System.out.println("Restaurant with ID " + restaurantId + " not found.");
    }

    // Method to view all restaurants and their menus
    public void viewRestaurantsAndMenus() {
        if (restaurants.isEmpty()) {
            System.out.println("No restaurants available.");
        } else {
            System.out.println("\n==== Restaurants and Menus ====");
            for (Restaurant restaurant : restaurants) {
                System.out.println("Restaurant: " + restaurant.getName() + " (ID: " + restaurant.getId() + ")");
                restaurant.showMenu();
            }
        }
    }


    public FoodItem getFoodItemFromRestaurant(int restaurantId, int foodId) {

    }
}

