package com.shopping;

import java.util.LinkedList;
import java.util.Stack;

public class PurchaseHistory {
	private Stack<LinkedList<String>> history;

	public PurchaseHistory() {
		history = new Stack<>();
	}

	public void saveCart(LinkedList<String> cart) {
		history.push(new LinkedList<>(cart));
		System.out.println("Cart saved to purchase history.");
	}

	public LinkedList<String> undoLastPurchase() {
		if (!history.isEmpty()) {
			System.out.println("Last purchase undone.");
			return history.pop();
		} else {
			System.out.println("No purchases to undo.");
			return null;
		}
	}

	public void viewPurchaseHistory() {
		if (history.isEmpty()) {
			System.out.println("No purchase history.");
		} else {
			System.out.println("Purchase history:");
			for (LinkedList<String> purchase : history) {
				System.out.println(purchase);
			}
		}
	}
}
