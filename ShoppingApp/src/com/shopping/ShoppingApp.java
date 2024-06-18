package com.shopping;

import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingApp {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		PurchaseHistory history = new PurchaseHistory();
		CustomerService service = new CustomerService();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Add item to cart");
			System.out.println("2. Remove item from cart");
			System.out.println("3. View items in cart");
			System.out.println("4. Save cart to purchase history");
			System.out.println("5. Undo last purchase");
			System.out.println("6. View purchase history");
			System.out.println("7. Add customer service request");
			System.out.println("8. Process customer service request");
			System.out.println("9. View pending customer service requests");
			System.out.println("10. Exit");
			System.out.print("Enter your choice: ");

			int choice = -1;
			try {
				choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number between 1 and 10.");
				scanner.nextLine(); // Consume the invalid input
				continue; // Restart the loop
			}

			switch (choice) {
			case 1:
				System.out.print("Enter item to add: ");
				String addItem = scanner.nextLine();
				cart.addItem(addItem);
				break;
			case 2:
				System.out.print("Enter item to remove: ");
				String removeItem = scanner.nextLine();
				cart.removeItem(removeItem);
				break;
			case 3:
				cart.viewItems();
				break;
			case 4:
				history.saveCart(cart.getCart());
				break;
			case 5:
				LinkedList<String> lastCart = history.undoLastPurchase();
				if (lastCart != null) {
					cart.setCart(lastCart);
				}
				break;
			case 6:
				history.viewPurchaseHistory();
				break;
			case 7:
				System.out.print("Enter customer service request: ");
				String request = scanner.nextLine();
				service.addRequest(request);
				break;
			case 8:
				service.processRequest();
				break;
			case 9:
				service.viewPendingRequests();
				break;
			case 10:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 10.");
			}
		}
	}
}
