package org.Bookstore.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EBook extends Book {
    private String filetype;

    public EBook(String ISBN, String title, int yearOfPublication, double price, String filetype) {
        super(ISBN, title, yearOfPublication, price);
        this.filetype = filetype;
    }
    public EBook(){}
    @Override
    public double buy(int quantity) throws Exception {
        return getPrice() * quantity;
    }
}
