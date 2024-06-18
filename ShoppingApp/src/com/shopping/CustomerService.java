package com.shopping;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerService {
	private Queue<String> serviceRequests;

	public CustomerService() {
		serviceRequests = new LinkedList<>();
	}

	public void addRequest(String request) {
		serviceRequests.add(request);
		System.out.println("Customer service request added: " + request);
	}

	public void processRequest() {
		if (!serviceRequests.isEmpty()) {
			System.out.println("Processing customer service request: " + serviceRequests.poll());
		} else {
			System.out.println("No customer service requests to process.");
		}
	}

	public void viewPendingRequests() {
		if (serviceRequests.isEmpty()) {
			System.out.println("No pending customer service requests.");
		} else {
			System.out.println("Pending customer service requests: " + serviceRequests);
		}
	}
}
