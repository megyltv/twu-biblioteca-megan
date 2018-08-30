package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library library;

    @Test
    public void showWelcomeMessagetest() {
        assertEquals("Welcome to the Library", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooksTest(){
        library=new Library();
        library.createListOfBooks();
        assertEquals("The C Programming Language | Dennis Ritchie | 1978",library.showListBooks());
    }

    @Test
    public void createListOfBookTest(){
        library=new Library();
        library.createListOfBooks();
        assertEquals("Test Driven Development: By Example",library.createListOfBooks().get(0).nameBook);
    }

    @Test
    public void checkoutSuccessfulTest(){
        library=new Library();
        library.createListOfBooks();
        assertEquals("Thank you! Enjoy the book",library.checkoutBook("Test Driven Development: By Example"));
    }

    @Test
    public void checkoutUnsuccessfulTest(){
        library=new Library();
        library.createListOfBooks();
        assertEquals("That book is not available",library.checkoutBook("Test Driven Development"));
    }

    @Test
    public void returnSuccessfulTest(){
        library=new Library();
        library.createListOfBooks();
        library.listBooks.get(0).checkout=false;
        assertEquals("Thank you for returning the book", library.returnBook("Test Driven Development: By Example"));
    }

    @Test
    public void returnUnsuccessfulTest(){
        library=new Library();
        library.createListOfBooks();
        library.listBooks.get(0).checkout=false;
        assertEquals("That is not a valid book to return",library.returnBook("Test Driven Development"));
    }

}
