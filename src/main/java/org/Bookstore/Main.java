package org.Bookstore;

import org.Bookstore.data.Book;
import org.Bookstore.data.DemoBook;
import org.Bookstore.data.EBook;
import org.Bookstore.data.PaperBook;
import org.Bookstore.services.BookstoreService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Quantum Book Store: Starting Tests ==========\n");

        // Initialize service
        BookstoreService bookstore = new BookstoreService();

        // --- Initialize Inventory ---
        System.out.println(">> Initializing Inventory...");
        Book paperBook = new PaperBook("ISBN-001", "Effective Java", 2017, 150.0, 5);
        Book eBook = new EBook("ISBN-002", "Python Tricks", 2022, 80.0,"pdf");
        Book demoBook = new DemoBook("ISBN-003", "AI Revolution", 2015);

        bookstore.addBook(paperBook);
        bookstore.addBook(eBook);
        bookstore.addBook(demoBook);

        System.out.println(">> Inventory initialized.\n");

        // --- Test Case 1: Buy PaperBook (Valid) ---
        System.out.println(">> Test 1: Buy 3 copies of PaperBook:");
        try {
            double total = bookstore.buyBook("ISBN-001", 3, "123 Cairo St.", "user@example.com");
            System.out.println("PaperBook purchase paid: $" + total);
        } catch (Exception e) {
            System.out.println("Failed to buy PaperBook: " + e.getMessage());
        }

        // --- Test Case 2: Buy EBook (Valid) ---
        System.out.println("\n>> Test 2: Buy 2 copies of EBook:");
        try {
            double total = bookstore.buyBook("ISBN-002", 2, "123 Cairo St.", "user@example.com");
            System.out.println("EBook purchase paid: $" + total);
        } catch (Exception e) {
            System.out.println("Failed to buy EBook: " + e.getMessage());
        }

        // --- Test Case 3: Buy DemoBook (Should Fail) ---
        System.out.println("\n>> Test 3: Attempt to buy DemoBook:");
        try {
            bookstore.buyBook("ISBN-003", 1, "123 Cairo St.", "user@example.com");
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // --- Test Case 4: Buy more than available stock (Should Fail) ---
        System.out.println("\n>> Test 4: Attempt to buy 5 PaperBooks (only 2 left):");
        try {
            bookstore.buyBook("ISBN-001", 5, "123 Cairo St.", "user@example.com");
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // --- Test Case 5: Buy with invalid ISBN (Should Fail) ---
        System.out.println("\n>> Test 5: Attempt to buy a book with invalid ISBN:");
        try {
            bookstore.buyBook("INVALID-ISBN", 1, "123 Cairo St.", "user@example.com");
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // --- Test Case 6: Buy remaining PaperBooks (Should Succeed) ---
        System.out.println("\n>> Test 6: Buy 2 remaining PaperBooks:");
        try {
            double total = bookstore.buyBook("ISBN-001", 2, "123 Cairo St.", "user@example.com");
            System.out.println("Successfully bought remaining PaperBooks. Paid: $" + total);
        } catch (Exception e) {
            System.out.println("Failed to buy remaining PaperBooks: " + e.getMessage());
        }

        // --- Test Case 7: Buy EBook again (Should Succeed) ---
        System.out.println("\n>> Test 7: Buy 1 more EBook (no stock limit):");
        try {
            double total = bookstore.buyBook("ISBN-002", 1, "123 Cairo St.", "user@example.com");
            System.out.println("EBook purchase successful. Paid: $" + total);
        } catch (Exception e) {
            System.out.println("Failed to buy EBook again: " + e.getMessage());
        }

        // --- Test Case 8: Remove outdated books ---
        System.out.println("\n>> Test 8: Remove books older than 6 years:");
        List<Book> removedBooks = bookstore.removeOutdatedBooks(6);
        if (removedBooks.isEmpty()) {
            System.out.println("No outdated books found.");
        } else {
            for (Book b : removedBooks) {
                System.out.println("Removed: " + b.getTitle() + " (" + b.getYearOfPublication() + ")");
            }
        }

        System.out.println("\n========== Quantum Book Store: All Tests Completed ==========");
    }
}
