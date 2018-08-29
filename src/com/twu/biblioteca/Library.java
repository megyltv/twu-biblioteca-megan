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
            if(listBooks.get(i).checkout) {
                detailsBook=listBooks.get(i).nameBook+" | "+listBooks.get(i).author+" | "+listBooks.get(i).publicationYear;
                System.out.println(detailsBook);
            }
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(){
        return listBooks;
    }

    public String checkoutBook(String nombre){
        Boolean status=true;
        String message="";
        for(int i=0;i<listBooks.size();i++){
            if(nombre.equals(listBooks.get(0).nameBook)){
                listBooks.get(i).checkout=false;
                status=listBooks.get(i).checkout;
                message="Thank you! Enjoy the book";
                System.out.println("Thank you! Enjoy the book");

            }
        }
        if(status=true){
            message="That book is not available";
        }

        return message;
    }
}
