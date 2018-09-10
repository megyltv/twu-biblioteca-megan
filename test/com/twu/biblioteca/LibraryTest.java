package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    public Library library;
    public ArrayList<Book> listBooks;

    @Before
    public void setUp(){
        library= new Library();
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2003));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
    }

    @Test
    public void shouldShowWelcomeMessageWhenIniatilizingObjectLibrary() {
        assertEquals("WELCOME TO THE LIBRARY :)", new Library().showWelcomeMessage());
    }

    @Test
    public void createListOfBookTest(){
        assertEquals("Test Driven Development: By Example",listBooks.get(0).nameBook);
    }

    @Test
    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList(){
        assertEquals("The C Programming Language \t| Dennis Ritchie \t| 1978",library.showListBooks());
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenCheckoutHappen(){
        assertEquals("Thank you! Enjoy the book",library.checkoutBook("Test Driven Development: By Example", 2003));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout(){
        assertEquals("That book is not available",library.checkoutBook("Test Driven Development",2003));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned(){
        library.listBooks.get(0).isAvailable =false;
        assertEquals("Thank you for returning the book",library.returnBook((library.listBooks.get(0))));

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn(){
        listBooks.get(0).isAvailable =true;
        assertEquals("That is not a valid book to return",library.returnBook((library.listBooks.get(0))));
    }

    @Test
    public void shouldReturnNameOfBookWhenItIsSearch(){
        assertEquals("Test Driven Development: By Example" ,library.searchBookinLibrary("Test Driven Development: By Example",2002).nameBook);
        assertEquals("Hello Book", library.searchBookinLibrary("Hello Book",2013).nameBook);
    }

}
