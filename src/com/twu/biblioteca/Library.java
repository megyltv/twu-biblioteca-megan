package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;
    public ArrayList<Book> listBooks;
    public String detailsBook;


    public Library() {
        welcomeMessage="Welcome to the Library";
        listBooks=new ArrayList<Book>();
    }

    public String showWelcomeMessage(){
        return welcomeMessage;
    }

    public String showListBooks(){
        for(int i=0;i<listBooks.size();i++){
            detailsBook=listBooks.get(i).nameBook;
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(Book newBook){
        listBooks.add(newBook);
        return listBooks;
    }
}
