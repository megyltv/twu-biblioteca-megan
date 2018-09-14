package com.twu.library.libraries;

import com.twu.library.Book;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary implements ItemLibrary {
    private Dictionary dictionary;
    private List<Book> listBooks;
    private Login login;
    private Book findBook;
    private PrinterReader printerReader;

    public BookLibrary(Login login) {

        this.login=login;
        printerReader=new PrinterReader();
        dictionary= new Dictionary();

        createListOfBooks();

    }

    public void createListOfBooks(){
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Harry Potter", "JK Rowling", 2001));
        listBooks.add(new Book("The Selection", "Kiera Cass", 2008));
        listBooks.add(new Book("Percy Jackson", "Rick Riordan", 2010));
        listBooks.add(new Book("Divergent", "Veronica Roth", 2012));
    }

    @Override
    public String showListItem() {
        String detailsBook = "";

        printerReader.printTitles(dictionary.TITLE_LIST_BOOKS);
        System.out.printf("%-40s |%-30s |%-20s\n", dictionary.TITLE_NAME_BOOK, dictionary.TITLE_AUTHOR_BOOK, dictionary.TITLE_YEAR_PUBLICATION);
        for (Book book:listBooks) {
            if (book.isAvailable()) {
                detailsBook = book.informationOfBook(book);
            }
        }
        return detailsBook;
    }

    @Override
    public String checkoutItem(String nameItem) {
        String message = dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        for (Book bookLooking : listBooks) {
            if (nameItem.equals(bookLooking.getNameBook()) && bookLooking.isAvailable()) {
                bookLooking.setAvailable(bookLooking.changeStatus());
                bookLooking.setUserIdWhenNotAvailable(login.getCurrentUser().getIdLibraryCode());
                message = dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_OUT;
                break;
            }
        }
        return message;
    }

    @Override
    public String checkinItem() {
        String message = dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_IN;
        for (Book bookLooking : listBooks) {
            if (findBook.getNameBook().equals(bookLooking.getNameBook()) && bookLooking.getPublicationYear() == findBook.getPublicationYear() &&
                    findBook.isAvailable() == bookLooking.isAvailable()) {
                bookLooking.setAvailable(bookLooking.changeStatus());
                bookLooking.setUserIdWhenNotAvailable("");
                message = dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;
            }
        }

        return message;
    }

    @Override
    public Object searchItem(String nameItem) {
        findBook=new Book(nameItem);
        for (Book bookLooking : listBooks) {
            if (nameItem.equals(bookLooking.getNameBook())) {
                findBook = bookLooking;

            }
        }
        return findBook;
    }



}
