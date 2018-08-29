package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;
    public ArrayList<Book> listBooks;


    public Library() {
        welcomeMessage="Welcome to the Library";
        listBooks=new ArrayList<Book>();
    }

    public String showWelcomeMessage(){
        return welcomeMessage;
    }

    public ArrayList<Book> showListBooks(){
        return listBooks;
    }
}
