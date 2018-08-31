package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    public Library library;
    public ArrayList<Book> listBooks;

    @Before
    public void initializeDataBefore(){
        library= new Library();
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2003));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
    }

    @Test
    public void showWelcomeMessageTest() {
        assertEquals("WELCOME TO THE LIBRARY :)", new Library().showWelcomeMessage());
    }

    @Test
    public void createListOfBookTest(){
        assertEquals("Test Driven Development: By Example",listBooks.get(0).nameBook);
    }

    @Test
    public void showListBooksTest(){
        assertEquals("The C Programming Language \t| Dennis Ritchie \t| 1978",library.showListBooks(listBooks));
    }

    @Test
    public void checkoutSuccessfulTest(){
        assertEquals("Thank you! Enjoy the book",library.checkoutBook("Test Driven Development: By Example", 2002));
    }

    @Test
    public void checkoutUnsuccessfulTest(){
        assertEquals("That book is not available",library.checkoutBook("Test Driven Development",2002));
    }

    @Test
    public void returnSuccessfulTest(){
        library.listBooks.get(0).checkout=false;
        assertEquals("Thank you for returning the book",library.returnBook((library.listBooks.get(0))));

    }

    @Test
    public void returnUnsuccessfulTest(){
        library.listBooks.get(0).checkout=false;
        assertEquals("Thank you for returning the book",library.returnBook((library.listBooks.get(0))));
    }

    @Test
    public void searchBookinLibraryTest(){
        assertEquals("Test Driven Development: By Example" ,library.searchBookinLibrary("Test Driven Development: By Example",2002).nameBook);
        assertEquals("Hello Book", library.searchBookinLibrary("Hello Book",2013).nameBook);
    }

}
