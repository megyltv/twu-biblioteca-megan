package com.twu.library;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class BookTest {
    public Book newBook;

    @Before
    public void SetUp() {
        newBook = new Book("Test Driven Development: By Example", "Kent Beck", 2002);

    }

    @Test
    public void shouldReturnStatusChangedWhenItIsCheckout() {
        boolean statusFalse = false;
        boolean statusTrue = true;
        Book bookCheckOut = new Book("Test Driven Development: By Example", "Kent Beck", 2002);

        newBook.setAvailable(statusTrue);
        bookCheckOut.setAvailable(statusFalse);

        assertEquals(statusFalse, newBook.changeStatus());
        assertEquals(statusTrue, bookCheckOut.changeStatus());
    }

    @Test
    public void shouldReturnInformationOfBookWhenItIsAsked() {
        String informationBook = "Test Driven Development: By Example \t| Kent Beck \t| 2002";

        assertEquals(informationBook, newBook.informationOfBook(newBook));
    }

    @Test
    public void shouldCreateNewBookWhenNewParametersAreReceivedForSearching() {
        Book bookCreated = new Book("Hello Book");

        assertThat(bookCreated, is(notNullValue()));
    }

}