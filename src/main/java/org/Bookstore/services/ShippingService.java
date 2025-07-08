package org.Bookstore.services;

import org.Bookstore.data.PaperBook;

public class ShippingService {
    public static void shipBook(String address, PaperBook book) {
        System.out.println("Shipping book " + book.getTitle() + " to " + address);
    }
}
