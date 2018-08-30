package com.twu.biblioteca;

public class Book {
    public String nameBook;
    public String author;
    public int publicationYear;
    public boolean checkout;

    public Book() {
    }

    public Book(String nameBook, String author, int publicationYear) {
        this.nameBook = nameBook;
        this.author = author;
        this.publicationYear = publicationYear;
        this.checkout=true;
    }

    public Book changeCheckout(Book bookCheckoutChange){
        if(checkout==false){
            bookCheckoutChange.checkout=true;
        }else{
            bookCheckoutChange.checkout=false;
        }

        return bookCheckoutChange;
    }


}
