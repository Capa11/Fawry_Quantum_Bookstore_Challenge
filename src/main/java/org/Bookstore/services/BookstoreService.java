package org.Bookstore.services;

import org.Bookstore.data.Book;
import org.Bookstore.data.EBook;
import org.Bookstore.data.PaperBook;

import java.util.*;

public class BookstoreService {
    Map<String,Book> books = new HashMap<String,Book>();

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }
    public double buyBook(String ISBN, int quantity, String address, String email) throws Exception {
        Book book = books.get(ISBN);
        if (book == null) {
            throw new Exception("Book with ISBN " + ISBN + " not found.");
        }
        double price = book.buy(quantity);
        if(book instanceof PaperBook paperBook) {
            ShippingService.shipBook(address, paperBook);
        }
        else if(book instanceof EBook eBook) {
            MailService.sendMail(email, eBook);
        }
        return price;
    }
    public List<Book> removeOutdatedBooks(int maxNumberOfYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removedBooks = new ArrayList<Book>();


        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Book> entry = iterator.next();
            Book book = entry.getValue();

            int age = currentYear - book.getYearOfPublication();
            if (age > maxNumberOfYears) {
                removedBooks.add(book);
                iterator.remove();
            }
        }
        return removedBooks;
    }


}
