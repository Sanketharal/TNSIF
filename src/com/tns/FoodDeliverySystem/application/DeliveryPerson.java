package com.tns.FoodDeliverySystem.application;

public class DeliveryPerson {
    private int deliveryPersonId;
    private String name;
    private String phoneNumber;

    public DeliveryPerson(int deliveryPersonId, String name, String phoneNumber) {
        this.deliveryPersonId = deliveryPersonId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

