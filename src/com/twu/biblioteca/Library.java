package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;
    public ArrayList<Book> listBooks;
    public String detailsBook;

    Boolean status;
    String message="";

    Boolean statusReturnBook;
    String messageReturnBook="";


    public Library() {
    }

    public String showWelcomeMessage(){
        welcomeMessage="Welcome to the Library";
        return welcomeMessage;
    }

    public String showListBooks(){
        for(int i=0;i<listBooks.size();i++){
            if(listBooks.get(i).checkout) {
                detailsBook=listBooks.get(i).nameBook+" \t| "+listBooks.get(i).author+" \t| "+listBooks.get(i).publicationYear;
                System.out.println(detailsBook);
            }
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(){
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        listBooks.add(new Book("Clean Code","Robert Cecil Martin",2008));
        listBooks.add(new Book("Code Complete","Steve McConnell",1993));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
        return listBooks;
    }

    public String checkoutBook(String nameBookCheckout){
        status=true;
        for(int i=0;i<listBooks.size();i++){
            if(nameBookCheckout.equals(listBooks.get(i).nameBook)){
                listBooks.get(i).changeCheckout(listBooks.get(i));
                status=listBooks.get(i).checkout;
                message="Thank you! Enjoy the book";
            }
        }
        if(status==true){
            message="That book is not available";
        }

        return message;
    }

    public String returnBook(String nameBookCheckout){
        statusReturnBook=false;

        for(int i=0;i<listBooks.size();i++){
            if(nameBookCheckout.equals(listBooks.get(i).nameBook)){
                listBooks.get(i).changeCheckout(listBooks.get(i));
                statusReturnBook=listBooks.get(i).checkout;
                messageReturnBook="Thank you for returning the book";
            }
        }

        if(statusReturnBook==false) {
            messageReturnBook = "That is not a valid book to return";
        }

        return messageReturnBook;
    }
}
