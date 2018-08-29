package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;
    public ArrayList<Book> listBooks;
    public String detailsBook;

    public Library() {
    }

    public Library(ArrayList<Book> listBooks) {

        this.listBooks=listBooks;
    }

    public String showWelcomeMessage(){
        welcomeMessage="Welcome to the Library";
        return welcomeMessage;
    }

    public String showListBooks(){
        for(int i=0;i<listBooks.size();i++){
            detailsBook=listBooks.get(i).nameBook+" | "+listBooks.get(i).author+" | "+listBooks.get(i).publicationYear;
            if(listBooks.get(i).checkout) {
                System.out.println(detailsBook);
            }
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(){
        return listBooks;
    }

    public Boolean checkoutBook(){
        listBooks.get(0).checkout=false;

        return listBooks.get(0).checkout;
    }
}
