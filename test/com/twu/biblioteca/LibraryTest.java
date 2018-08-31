package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Library library= new Library();

    @Test
    public void showWelcomeMessageTest() {
        assertEquals("WELCOME TO THE LIBRARY", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooksTest(){
        library.createListOfBooks();
        assertEquals("The C Programming Language \t| Dennis Ritchie \t| 1978",library.showListBooks());
    }

    @Test
    public void createListOfBookTest(){
        library.createListOfBooks();
        assertEquals("Test Driven Development: By Example",library.createListOfBooks().get(0).nameBook);
    }

    @Test
    public void checkoutSuccessfulTest(){
        library.createListOfBooks();
        assertEquals("Thank you! Enjoy the book",library.checkoutBook("Test Driven Development: By Example", 2002));
    }

    @Test
    public void checkoutUnsuccessfulTest(){
        library.createListOfBooks();
        assertEquals("That book is not available",library.checkoutBook("Test Driven Development",2002));
    }

    @Test
    public void returnSuccessfulTest(){
        library.createListOfBooks();
        library.listBooks.get(0).checkout=false;
        assertEquals("Thank you for returning the book", library.returnBook("Test Driven Development: By Example",2002));

    }

    @Test
    public void returnUnsuccessfulTest(){
        library.createListOfBooks();
        library.listBooks.get(0).checkout=false;
        assertEquals("That is not a valid book to return",library.returnBook("Test Driven Development",2002));
    }

}
