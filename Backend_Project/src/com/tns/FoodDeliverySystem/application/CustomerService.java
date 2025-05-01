package com.tns.FoodDeliverySystem.application;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomer(int customerId) {
        return customers.stream()
                .filter(c -> c.getUserId() == customerId)
                .findFirst()
                .orElse(null);
    }
}

