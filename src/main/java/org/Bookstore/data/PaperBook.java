package org.Bookstore.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaperBook extends Book {
    private int stock;
    public PaperBook(String ISBN, String title, int yearOfPublication, double price, int stock) {
        super(ISBN, title, yearOfPublication, price);
        this.stock = stock;
    }
    public PaperBook() {}
    @Override
    public double buy(int quantity) throws Exception {
        if (quantity <= 0) throw new Exception("Invalid quantity");
        if(stock-quantity<0) throw new Exception("It is not available in the inventory");
        stock-=quantity;
        return getPrice() * quantity;
    }
}
