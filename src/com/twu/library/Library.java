package com.twu.library;

import com.twu.utils.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> listBooks;
    private Book findBook;
    private Dictionary dictionary;

    private Boolean status, statusReturnedBook;

    public Library() {
        listBooks = createListOfBooks();
        dictionary=new Dictionary();
    }


    public String showWelcomeMessage() {
        String welcomeMessage;
        welcomeMessage = dictionary.MESSAGE_WELCOME_TO_LIBRARY;
        return welcomeMessage;
    }

    public String showListBooks() {
        String detailsBook = "";
        System.out.println("\nLIST OF BOOKS\n");
        System.out.printf("%-40s |%-30s |%-20s\n", dictionary.TITLE_NAME_BOOK, dictionary.TITLE_AUTHOR_BOOK, dictionary.TITLE_YEAR_PUBLICATION);
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).isAvailable()) {
                detailsBook = listBooks.get(i).informationOfBook(listBooks.get(i));
            }
        }
        return detailsBook;
    }

    public List<Book> createListOfBooks() {
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Harry Potter", "JK Rowling", 2001));
        listBooks.add(new Book("The Selection", "Kiera Cass", 2008));
        listBooks.add(new Book("Percy Jackson", "Rick Riordan", 2010));
        listBooks.add(new Book("Divergent", "Veronica Roth", 2012));
        return listBooks;
    }

    public String checkoutBook(String nameBookCheckout, int yearBook) {
        String message = "";
        status = true;
        for (Book bookLooking : listBooks) {
            System.out.println(bookLooking.getNameBook() + " " + bookLooking.isAvailable());
            if (nameBookCheckout.equals(bookLooking.getNameBook()) && bookLooking.getPublicationYear() == yearBook && bookLooking.isAvailable()) {
                bookLooking.setAvailable(bookLooking.changeCheckout());
                status = bookLooking.isAvailable();
                message = dictionary.MESSAGE_SUCCESSFUL_BOOK_CHECK_OUT;
                break;
            }
        }
        if (status) {
            message = dictionary.MESSAGE_UNSUCCESSFUL_BOOK_CHECK_OUT;
        }
        return message;
    }

    public String returnBook() {
        String message = "";
        statusReturnedBook = false;
        for (Book bookLooking : listBooks) {
            if (findBook.getNameBook().equals(bookLooking.getNameBook()) && bookLooking.getPublicationYear() == findBook.getPublicationYear() &&
                    findBook.isAvailable() == bookLooking.isAvailable()) {
                bookLooking.setAvailable(bookLooking.changeCheckout());
                statusReturnedBook = bookLooking.isAvailable();
                message = dictionary.MESSAGE_SUCCESSFUL_BOOK_CHECK_IN;
            }
        }
        if (!statusReturnedBook) {
            message = dictionary.MESSAGE_UNSUCCESSFUL_BOOK_CHECK_IN;

        }

        return message;
    }

    public Book searchBookinLibrary(String nameBook, int yearBook) {
        findBook = new Book();
        for (Book bookLooking : listBooks) {
            if (nameBook.equals(bookLooking.getNameBook()) && bookLooking.getPublicationYear() == yearBook) {
                findBook = bookLooking;

            } else {
                findBook = new Book(nameBook, yearBook);
            }
        }
        return findBook;
    }

}
