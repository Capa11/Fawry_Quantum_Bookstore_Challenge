package org.Bookstore.data;

public class DemoBook extends Book {

    public DemoBook() {}
    public DemoBook(String ISBN, String title, int yearOfPublication) {
        super(ISBN, title, yearOfPublication, 0.0);
    }

    @Override
    public double buy(int quantity) throws Exception {
        throw new Exception("This is a demo book, not for sale");
    }
}
