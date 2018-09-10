package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> listBooks;
    private Book findBook;

    private Boolean status, statusReturnedBook;

    public Library() {
        createListOfBooks();
    }


    public String showWelcomeMessage(){
        String welcomeMessage;
        welcomeMessage="WELCOME TO THE LIBRARY :)";
        return welcomeMessage;
    }

    public String showListBooks(){
        String detailsBook="";
        System.out.println("\nLIST OF BOOKS\n");
        System.out.printf("%-40s |%-30s |%-20s\n", "NAME OF BOOK", "AUTHOR", "YEAR OF PUBLICATION");
        for(int i=0;i<listBooks.size();i++){
            if(listBooks.get(i).isAvailable()) {
                detailsBook=listBooks.get(i).informationOfBook(listBooks.get(i));
            }
        }
        return detailsBook;
    }

    public List<Book> createListOfBooks(){
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2003));
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        listBooks.add(new Book("Clean Code","Robert Cecil Martin",2008));
        listBooks.add(new Book("Code Complete","Steve McConnell",1993));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
        return listBooks;
    }

    public String checkoutBook(String nameBookCheckout, int yearBook){
        String message="";
        status=true;
        for(int i=0;i<listBooks.size();i++){
            if(nameBookCheckout.equals(listBooks.get(i).getNameBook())&&listBooks.get(i).getPublicationYear()==yearBook){
                listBooks.get(i).changeCheckout(listBooks.get(i));
                status=listBooks.get(i).isAvailable();
                message="Thank you! Enjoy the book";
                break;
            }
        }
        if(status){
            message="That book is not available";
        }
        return message;
    }

    public String returnBook(Book newBook){
        String message="";
        statusReturnedBook=false;
        for(int i=0;i<listBooks.size();i++){
            if(newBook.getNameBook().equals(listBooks.get(i).getNameBook()) && listBooks.get(i).getPublicationYear()==newBook.getPublicationYear() &&
                    !newBook.isAvailable()){
                listBooks.get(i).changeCheckout(listBooks.get(i));
                statusReturnedBook=listBooks.get(i).isAvailable();
                message="Thank you for returning the book";
            }
        }
        if(!statusReturnedBook) {
            message = "That is not a valid book to return";
        }

        return message;
    }

    public Book searchBookinLibrary(String nameBook, int yearBook){
        findBook = new Book();
        for (int i = 0; i < listBooks.size(); i++) {
            if (nameBook.equals(listBooks.get(i).getNameBook()) && listBooks.get(i).getPublicationYear() == yearBook) {
                findBook = listBooks.get(i);
            }else{
                findBook = new Book(nameBook, yearBook);
            }
        }
        return findBook;
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

}
