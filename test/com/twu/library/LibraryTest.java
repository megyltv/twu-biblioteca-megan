package com.twu.library;


import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.DISCARDING;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;


public class LibraryTest {
    public Library library;
    public List<Book> listBooks;
    Dictionary dictionary;

    @Before
    public void setUp() {
        library = new Library();
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Harry Potter", "JK Rowling", 2001));
        listBooks.add(new Book("Divergent", "Veronica Roth", 2012));
    }

    @Test
    public void shouldShowWelcomeMessageWhenIniatilizingObjectLibrary() {
        assertEquals(dictionary.messageWelcomeToLibrary, new Library().showWelcomeMessage());
    }

    @Test
    public void shouldReturnSizeOfListOfBooksWhenItIsCreated() {
        List<Book> listBooksCreated = library.createListOfBooks();
        int sizeList = library.listBooks.size();

        assertThat(listBooksCreated, hasSize(sizeList));
    }


    @Test
    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList() {
        String informationBook = "Divergent \t| Veronica Roth \t| 2012";

        assertEquals(informationBook, library.showListBooks());
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenCheckoutHappen() {
        String messageExpected = "Thank you! Enjoy the book";
        String nameBook = "Harry Potter";
        int yearBook = 2001;


        assertEquals(messageExpected, library.checkoutBook(nameBook, yearBook));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
        String messageExpected = "That book is not available";

        assertEquals(messageExpected, library.checkoutBook("Test Driven Development", 2003));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
        String nameBook = "Harry Potter";
        int year = 2001;

        library.checkoutBook(nameBook, year);

        library.searchBookinLibrary(nameBook, year);

        assertEquals("Thank you for returning the book", library.returnBook());

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
        String nameBook = "Test Driven Development: By Example";
        int year = 2002;

        library.searchBookinLibrary(nameBook, year);

        assertEquals("That is not a valid book to return", library.returnBook());
    }

    @Test
    public void shouldReturnNameOfBookWhenItIsSearch() {
        Book bookSearchedInLibrary = library.searchBookinLibrary("Harry Potter", 2001);
        Book bookSearchedNotInLibrary = library.searchBookinLibrary("Hello Book", 2013);

        assertThat(bookSearchedInLibrary, is(notNullValue()));
        assertThat(bookSearchedNotInLibrary, is(notNullValue()));

    }

}
