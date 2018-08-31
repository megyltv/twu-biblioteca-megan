package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public ArrayList<Book> listBooks;
    protected String welcomeMessage;
    protected String detailsBook;
    protected Book findBook;
    protected Boolean statusReturnBook;
    protected String messageReturnBook="";

    private Boolean status;
    protected String message="";

    public Library() {
        createListOfBooks();
    }


    public String showWelcomeMessage(){
        welcomeMessage="WELCOME TO THE LIBRARY";
        return welcomeMessage;
    }

    public String showListBooks(){
        System.out.println("\nLIST OF BOOKS\n");
        System.out.printf("%-40s |%-30s |%-20s\n", "NAME OF BOOK", "AUTHOR", "YEAR OF PUBLICATION");
        for(int i=0;i<listBooks.size();i++){
            if(listBooks.get(i).checkout) {
                detailsBook=listBooks.get(i).informationOfBook(listBooks.get(i));
            }
        }
        return detailsBook;
    }

    public ArrayList<Book> createListOfBooks(){
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2003));
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        listBooks.add(new Book("Clean Code","Robert Cecil Martin",2008));
        listBooks.add(new Book("Code Complete","Steve McConnell",1993));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
        return listBooks;
    }

    public String checkoutBook(String nameBookCheckout, int yearBook){
        status=true;
        for(int i=0;i<listBooks.size();i++){
            if(nameBookCheckout.equals(listBooks.get(i).nameBook)&&listBooks.get(i).publicationYear==yearBook){
                listBooks.get(i).changeCheckout(listBooks.get(i));
                status=listBooks.get(i).checkout;
                message="Thank you! Enjoy the book";
                break;
            }
        }
        if(status==true){
            message="That book is not available";
        }

        return message;
    }

    public String returnBook(Book newBook){
        statusReturnBook=false;
        for(int i=0;i<listBooks.size();i++){
            if(newBook.nameBook.equals(listBooks.get(i).nameBook)&&listBooks.get(i).publicationYear==newBook.publicationYear&&!newBook.checkout){
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

    public Book searchBookinLibrary(String nameBook, int yearBook){
        findBook = new Book();
        for (int i = 0; i < listBooks.size(); i++) {
            if (nameBook.equals(listBooks.get(i).nameBook) && listBooks.get(i).publicationYear == yearBook) {
                findBook = listBooks.get(i);
            }else{
                findBook.nameBook=nameBook;
                findBook.publicationYear=yearBook;
            }
        }
        return findBook;
    }
}
