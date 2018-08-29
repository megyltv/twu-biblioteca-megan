package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;
    public ArrayList<Book> listBooks;
    public String detailsBook;

    public Library() {
        welcomeMessage="Welcome to the Library";
    }

    public Library(ArrayList<Book> listBooks) {
        welcomeMessage="Welcome to the Library";
        this.listBooks=listBooks;
    }

    public String showWelcomeMessage(){
        return welcomeMessage;
    }

    public String showListBooks(){
        for(int i=0;i<listBooks.size();i++){
            detailsBook=listBooks.get(i).nameBook+" | "+listBooks.get(i).author+" | "+listBooks.get(i).publicationYear;
            System.out.println(detailsBook);
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(){
        return listBooks;
    }
}
