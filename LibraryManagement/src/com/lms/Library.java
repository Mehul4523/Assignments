package com.lms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
	private List<Book> books;

	public Library() {
		books = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
		Collections.sort(books);
	}

	public void removeBook(String title) {
		books.removeIf(book -> book.getTitle().equals(title));
		System.out.println("Book with title '" + title + "' has been removed.");
	}

	public void displayBooks() {
		if (books.isEmpty()) {
			System.out.println("No books in the library.");
		} else {
			System.out.println("Books in the library:");
			for (Book book : books) {
				System.out.println(book);
			}
		}
	}

	public Book linearSearch(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				return book;
			}
		}
		return null;
	}

	public Book binarySearch(String title) {
		int left = 0;
		int right = books.size() - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			Book midBook = books.get(mid);
			int comparison = midBook.getTitle().compareTo(title);

			if (comparison == 0) {
				return midBook;
			} else if (comparison < 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return null;
	}
}
