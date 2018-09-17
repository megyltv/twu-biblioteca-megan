package com.twu.library;

import com.twu.utils.PrinterReader;

public class Book {
    private String nameBook;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    private PrinterReader printerReader;

    public Book() {
    }

    public Book(String nameBook, String author, int publicationYear) {
        this.nameBook = nameBook;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
        this.printerReader=new PrinterReader();
    }

    public Book(String nameBookReceived) {
        this.nameBook = nameBookReceived;
    }

    public boolean changeStatus() {
        return !isAvailable;
    }

    public String informationOfBook(Book newBook) {
        printInformationOfBook(newBook);
        return newBook.nameBook + " \t| " + newBook.author + " \t| " + newBook.publicationYear;
    }

    public void printInformationOfBook(Book newBook) {
        printerReader.printInformationOfBooks(newBook);
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

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

}
