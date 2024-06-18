package com.lms;

import java.util.Scanner;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose an operation:");
			System.out.println("1. Add book to the library");
			System.out.println("2. Remove book from the library");
			System.out.println("3. Display all books");
			System.out.println("4. Search book by title using Linear Search");
			System.out.println("5. Search book by title using Binary Search");
			System.out.println("6. Compare Linear and Binary Search performance");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter title: ");
				String title = scanner.nextLine();
				System.out.print("Enter author: ");
				String author = scanner.nextLine();
				System.out.print("Enter ISBN: ");
				String ISBN = scanner.nextLine();
				Book book = new Book(title, author, ISBN);
				library.addBook(book);
				System.out.println("Book added to the library.");
				break;
			case 2:
				System.out.print("Enter title of the book to remove: ");
				String removeTitle = scanner.nextLine();
				library.removeBook(removeTitle);
				break;
			case 3:
				library.displayBooks();
				break;
			case 4:
				System.out.print("Enter title of the book to search (Linear Search): ");
				String linearTitle = scanner.nextLine();
				long startTime = System.nanoTime();
				Book foundBookLinear = library.linearSearch(linearTitle);
				long endTime = System.nanoTime();
				if (foundBookLinear != null) {
					System.out.println("Book found: " + foundBookLinear);
					System.out.println("Time taken (Linear Search): " + (endTime - startTime) + " nanoseconds");
				} else {
					System.out.println("Book not found.");
				}
				break;
			case 5:
				System.out.print("Enter title of the book to search (Binary Search): ");
				String binaryTitle = scanner.nextLine();
				startTime = System.nanoTime();
				Book foundBookBinary = library.binarySearch(binaryTitle);
				endTime = System.nanoTime();
				if (foundBookBinary != null) {
					System.out.println("Book found: " + foundBookBinary);
					System.out.println("Time taken (Binary Search): " + (endTime - startTime) + " nanoseconds");
				} else {
					System.out.println("Book not found.");
				}
				break;
			case 6:
				System.out.print("Enter title of the book to search: ");
				String compareTitle = scanner.nextLine();
				startTime = System.nanoTime();
				Book compareBookLinear = library.linearSearch(compareTitle);
				endTime = System.nanoTime();
				long linearTime = endTime - startTime;

				startTime = System.nanoTime();
				Book compareBookBinary = library.binarySearch(compareTitle);
				endTime = System.nanoTime();
				long binaryTime = endTime - startTime;

				if (compareBookLinear != null) {
					System.out.println("Book found (Linear Search): " + compareBookLinear);
				} else {
					System.out.println("Book not found (Linear Search).");
				}

				if (compareBookBinary != null) {
					System.out.println("Book found (Binary Search): " + compareBookBinary);
					System.out.println("Time taken (Linear Search): " + linearTime + " nanoseconds");
					System.out.println("Time taken (Binary Search): " + binaryTime + " nanoseconds");
				} else {
					System.out.println("Book not found (Binary Search).");
				}
				break;
			case 7:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
