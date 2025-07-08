package org.Bookstore.services;

import org.Bookstore.data.EBook;

public class MailService {
    public static void sendMail(String email, EBook book) {
        System.out.println("Sending book " + book.getTitle() + " to " + email);
    }
}
