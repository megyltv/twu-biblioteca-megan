package com.twu.biblioteca;

public class Book {
    private String nameBook;
    private String author;
    private int publicationYear;
    private boolean isAvailable;

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


    public boolean changeCheckout(){
        return !isAvailable;
    }

    public String informationOfBook(Book newBook){
        printInformationOfBook(newBook);
        return newBook.nameBook+" \t| "+newBook.author+" \t| "+newBook.publicationYear;
    }

    public void printInformationOfBook(Book newBook){
        System.out.printf("%-40s |%-30s |%-20s\n", newBook.nameBook, newBook.author, newBook.publicationYear);
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getNameBook() {
        return nameBook;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
