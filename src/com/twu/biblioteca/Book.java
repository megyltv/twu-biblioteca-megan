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

}
