package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    Book newBook=new Book("Test Driven Development: By Example","Kent Beck",2002);

    @Test
    public void showWelcomeMessagetest() {
        assertEquals("Welcome to the Library", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooksTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        assertEquals("Test Driven Development: By Example | Kent Beck | 2002",new Library(listBooks).showListBooks());
    }

    @Test
    public void createListOfBookTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        assertEquals("Test Driven Development: By Example",new Library(listBooks).createListOfBooks().get(0).nameBook);
    }

    @Test
    public void checkoutSuccessfulTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        assertEquals("Thank you! Enjoy the book",new Library(listBooks).checkoutBook("Test Driven Development: By Example"));
    }

    @Test
    public void checkoutUnsuccessfulTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        assertEquals("That book is not available",new Library(listBooks).checkoutBook("Test Driven Development"));
    }

    @Test
    public void returnSuccessfulTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        newBook.checkout=false;
        assertEquals("Thank you for returning the book", new Library(listBooks).returnBook("Test Driven Development: By Example"));
    }

    @Test
    public void returnUnsuccessfulTest(){
        ArrayList<Book> listBooks=new ArrayList<Book>();
        listBooks.add(newBook);
        newBook.checkout=false;
        assertEquals("That is not a valid book to return",new Library(listBooks).returnBook("Test Driven Development"));
    }

}
