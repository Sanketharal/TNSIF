package com.tns.FoodDeliverySystem.application;

import com.tns.FoodDeliverySystem.entities.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private List<Order> orders = new ArrayList<>(); // List to store all orders
    private int currentOrderId = 1; // To generate unique order IDs

    // Method to place an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
    }

    // Method to view all orders
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders have been placed yet.");
        } else {
            System.out.println("\n==== List of Orders ====");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    // Method to assign a delivery person to an order
    public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
        Order orderToAssign = null;

        // Find the order by ID
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                orderToAssign = order;
                break;
            }
        }

        if (orderToAssign == null) {
            System.out.println("Order with ID " + orderId + " not found.");
            return;
        }

        // Assign delivery person to the order
        DeliveryPerson deliveryPerson = new DeliveryPerson(deliveryPersonId, "DeliveryPerson-" + deliveryPersonId, "Phone-" + deliveryPersonId);
        orderToAssign.setDeliveryPerson(deliveryPerson);
        System.out.println("Delivery person with ID " + deliveryPersonId + " assigned to Order ID " + orderId);
    }

    // Method to generate a unique order ID
    public int generateOrderId() {
        return currentOrderId++;
    }
}

