package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    public ArrayList<Book> listBooks;


    public Library() {
    }

    public String showWelcomeMessage(){
        return "Welcome to the Library";
    }
}
