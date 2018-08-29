package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void showWelcomeMessagetest() {
        assertEquals("Welcome to the Library", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooksTest(){
        assertEquals("Test Driven Development: By Example",new Library().showListBooks().get(0).nameBook);
    }

    @Test
    public void createListOfBookTest(){
        Book newBook = new Book("Test Driven Development: By Example","Kent Beck",2002);
        assertEquals("Test Driven Development: By Example",new Library().createListOfBooks(newBook).get(0).nameBook);
    }

}
