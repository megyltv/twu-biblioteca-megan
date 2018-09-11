package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    public Book newBook;

    @Before
    public void initializeDataTest() {

        newBook= new Book("Test Driven Development: By Example", "Kent Beck", 2002);
    }

    @Test
    public void shouldReturnStatusChangedWhenItIsCheckout(){
        assertEquals(false,newBook.changeCheckout());

        newBook.setAvailable(false);

        assertEquals(true,newBook.changeCheckout());
    }

    @Test
    public void shouldReturnInformationOfBookWhenItIsAsked(){
        assertEquals("Test Driven Development: By Example \t| Kent Beck \t| 2002", newBook.informationOfBook(newBook));
    }

    @Test
    public void shouldCreateNewBookWhenNewParametersAreReceivedForSearching(){
        assertEquals("Hello Book", new Book("Hello Book",2013).getNameBook());
    }

}