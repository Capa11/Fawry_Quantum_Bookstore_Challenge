package org.Bookstore.data;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public abstract class Book {
    private String ISBN;
    private String title;
    @Setter(AccessLevel.NONE)
    private int yearOfPublication;
    private double price;

    public Book(String ISBN, String title, int yearOfPublication, double price) {
        if(!validationYearOfPublication(yearOfPublication)) {
            throw new IllegalArgumentException("Invalid year of publication");
        }
        this.ISBN = ISBN;
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
    }
    public Book(){}



    public abstract double buy(int quantity) throws Exception;

    public void setYearOfPublication(int yearOfPublication) {
        if(!validationYearOfPublication(yearOfPublication)) {
            throw new IllegalArgumentException("Invalid year of publication");
        }
        this.yearOfPublication = yearOfPublication;
    }


    private boolean validationYearOfPublication(int yearOfPublication) {
        return yearOfPublication <= Calendar.getInstance().get(Calendar.YEAR) && yearOfPublication >= 0;
    }
}
