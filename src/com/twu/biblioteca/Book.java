package com.twu.biblioteca;

public class Book {
    protected String nameBook;
    protected String author;
    protected int publicationYear;
    protected boolean isAvailable;

    public Book(){}

    public Book(String nameBook, String author, int publicationYear) {
        this.nameBook = nameBook;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable =true;
    }

    public Book(String nameBookReceived, int yearBookReceived){
        this.nameBook=nameBookReceived;
        this.publicationYear=yearBookReceived;
    }


    public Book changeCheckout(Book bookCheckoutChange){
        if(!isAvailable){
            bookCheckoutChange.isAvailable =true;
        }else{
            bookCheckoutChange.isAvailable =false;
        }

        return bookCheckoutChange;
    }

    public String informationOfBook(Book newBook){
        printInformationOfBook(newBook);
        return newBook.nameBook+" \t| "+newBook.author+" \t| "+newBook.publicationYear;
    }

    public void printInformationOfBook(Book newBook){
        System.out.printf("%-40s |%-30s |%-20s\n", newBook.nameBook, newBook.author, newBook.publicationYear);
    }


}
