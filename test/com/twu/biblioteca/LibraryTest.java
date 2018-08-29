package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void showWelcomeMessagetest() {
        assertEquals("Welcome to the Library", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooksTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        assertEquals("Test Driven Development: By Example | Kent Beck | 2002",new Library(listBooks).showListBooks());
    }

    @Test
    public void createListOfBookTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        assertEquals("Test Driven Development: By Example",new Library(listBooks).createListOfBooks().get(0).nameBook);
    }


}
