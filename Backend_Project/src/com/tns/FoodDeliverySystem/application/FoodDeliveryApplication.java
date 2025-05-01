package com.tns.FoodDeliverySystem.application;

//import com.tns.FoodDeliverySystem.entities.*;
//import com.tns.FoodDeliverySystem.services.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryApplication {

	public static void main(String[] args) {
		// Initialize
		
		 FoodService foodService = new FoodService();
	     OrderService orderService = new OrderService();
	     List<DeliveryPerson> deliveryPersons = new ArrayList<>();

        Restaurant restaurant = new Restaurant(101, "Food Paradise");
        restaurant.addFoodItem(new FoodItem(1, "Pizza", 250.0));
        restaurant.addFoodItem(new FoodItem(2, "Burger", 150.0));
        foodService.addRestaurant(restaurant);
        
        DeliveryPerson dp1 = new DeliveryPerson(201, "John Smith", "9876543210");
        DeliveryPerson dp2 = new DeliveryPerson(202, "Emily Davis", "8765432109");
        deliveryPersons.add(dp1);
        deliveryPersons.add(dp2);


        // Main Menu
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
        	 System.out.println("\n==== Online Food Delivery System ====");
             System.out.println("1. Admin Menu");
             System.out.println("2. Customer Menu");
             System.out.println("3. Exit");
             System.out.print("Enter your choice: ");
             choice = scanner.nextInt();

             switch (choice) {
             case 1:
                 adminMenu(scanner, foodService, orderService, deliveryPersons);
                 break;
             case 2:
                 customerMenu(scanner, foodService, orderService);
                 break;
             case 3:
                 System.out.println("Exiting the system. Thank you!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     } while (choice != 3);

     scanner.close();
 }
	 private static void adminMenu(Scanner scanner, FoodService foodService, OrderService orderService, List<DeliveryPerson> deliveryPersons) {
	        int adminChoice;
	        do {
	            System.out.println("\n==== Admin Menu ====");
	            System.out.println("1. Add Restaurant");
	            System.out.println("2. Add Food Item to Restaurant");
	            System.out.println("3. Remove Food Item from Restaurant");
	            System.out.println("4. View Restaurants and Menus");
	            System.out.println("5. View Orders");
	            System.out.println("6. Add Delivery Person");
	            System.out.println("7. Assign Delivery Person to Order");
	            System.out.println("8. Exit Admin Menu");
	            System.out.print("Enter your choice: ");
	            adminChoice = scanner.nextInt();

	            switch (adminChoice) {
	                case 1:
	                    System.out.print("Enter Restaurant ID: ");
	                    int restaurantId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Restaurant Name: ");
	                    String restaurantName = scanner.nextLine();
	                    foodService.addRestaurant(new Restaurant(restaurantId, restaurantName));
	                    System.out.println("Restaurant added successfully!");
	                    break;
	                case 2:
	                    System.out.print("Enter Restaurant ID: ");
	                    restaurantId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Food Item ID: ");
	                    int foodId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Food Item Name: ");
	                    String foodName = scanner.nextLine();
	                    System.out.print("Enter Food Item Price: ");
	                    double foodPrice = scanner.nextDouble();
	                    foodService.addFoodItemToRestaurant(restaurantId, new FoodItem(foodId, foodName, foodPrice));
	                    break;
	                case 3:
	                    System.out.print("Enter Restaurant ID: ");
	                    restaurantId = scanner.nextInt();
	                    System.out.print("Enter Food Item ID to remove: ");
	                    foodId = scanner.nextInt();
	                    foodService.removeFoodItemFromRestaurant(restaurantId, foodId);
	                    break;
	                case 4:
	                    foodService.viewRestaurantsAndMenus();
	                    break;
	                case 5:
	                    orderService.viewOrders();
	                    break;
	                case 6:
	                    System.out.print("Enter Delivery Person ID: ");
	                    int deliveryPersonId = scanner.nextInt();
	                    scanner.nextLine(); // Consume newline
	                    System.out.print("Enter Delivery Person Name: ");
	                    String deliveryPersonName = scanner.nextLine();
	                    System.out.print("Enter Delivery Person Phone Number: ");
	                    String deliveryPersonPhone = scanner.nextLine();
	                    deliveryPersons.add(new DeliveryPerson(deliveryPersonId, deliveryPersonName, deliveryPersonPhone));
	                    System.out.println("Delivery person added successfully!");
	                    break;
	                case 7:
	                    System.out.print("Enter Order ID: ");
	                    int orderId = scanner.nextInt();
	                    System.out.print("Enter Delivery Person ID: ");
	                    deliveryPersonId = scanner.nextInt();
	                    orderService.assignDeliveryPersonToOrder(orderId, deliveryPersonId);
	                    break;
	                case 8:
	                    System.out.println("Exiting Admin Menu.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (adminChoice != 8);
	    }

	    private static void customerMenu(Scanner scanner, FoodService foodService, OrderService orderService) {
	        System.out.print("Enter Customer ID: ");
	        int customerId = scanner.nextInt();
	        scanner.nextLine(); // Consume newline
	        System.out.print("Enter Customer Name: ");
	        String customerName = scanner.nextLine();
	        System.out.print("Enter Customer Address: ");
	        String customerAddress = scanner.nextLine();
	        Customer customer = new Customer(customerId, customerName, "email@example.com", "password123", customerAddress, "9876543210");
	        int customerChoice;
	        do {
	            System.out.println("\n==== Customer Menu ====");
	            System.out.println("1. View Restaurants and Menus");
	            System.out.println("2. Add Food Item to Cart");
	            System.out.println("3. View Cart");
	            System.out.println("4. Place Order");
	            System.out.println("5. Exit Customer Menu");
	            System.out.print("Enter your choice: ");
	            customerChoice = scanner.nextInt();

	            switch (customerChoice) {
	                case 1:
	                    foodService.viewRestaurantsAndMenus();
	                    break;
	                case 2:
	                    System.out.print("Enter Restaurant ID: ");
	                    int restaurantId = scanner.nextInt();
	                    System.out.print("Enter Food Item ID: ");
	                    int foodId = scanner.nextInt();
	                    System.out.print("Enter Quantity: ");
	                    int quantity = scanner.nextInt();
	                    FoodItem foodItem = foodService.getFoodItemFromRestaurant(restaurantId, foodId);
	                    if (foodItem != null) {
	                        customer.addItemToCart(foodItem, quantity);
	                        System.out.println(quantity + " x " + foodItem.getName() + " added to cart.");
	                    } else {
	                        System.out.println("Food item not found.");
	                    }
	                    break;
	                case 3:
	                    customer.viewCart();
	                    break;
	                case 4:
	                    Order order = new Order(orderService.generateOrderId(), customer, customer.getAddress());
	                    orderService.placeOrder(order);
	                    customer.clearCart();
	                    System.out.println("Order placed successfully! Your order ID is: " + order.getOrderId());
	                    break;
	                case 5:
	                    System.out.println("Exiting Customer Menu.");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        } while (customerChoice != 5);
	    }

	}


