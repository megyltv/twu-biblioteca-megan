package com.twu.library;


import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

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
    public List<Movie> listMovies;
    Dictionary dictionary;
    public Login login;

    @Before
    public void setUp() {
        login=new Login();
        library = new Library(new BookLibrary(login));
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Harry Potter", "JK Rowling", 2001));
        listBooks.add(new Book("Divergent", "Veronica Roth", 2012));
    }

    @Test
    public void shouldShowWelcomeMessageWhenIniatilizingObjectLibrary() {
        assertEquals(dictionary.MESSAGE_WELCOME_TO_LIBRARY, new Library(new BookLibrary(login)).showWelcomeMessage());
    }

//    @Test
//    public void shouldReturnSizeOfListOfBooksWhenItIsCreated() {
//        List<Book> listBooksCreated = library.();
//        int sizeList = library.listBooks.size();
//
//        assertThat(listBooksCreated, hasSize(sizeList));
//    }

//    @Test
//    public void shouldReturnSizeOfListOfMoviesWhenItIsCreated(){
//        List<Movie> listMoviesCreated = library.createListOfMovies();
//        int sizeList=library.listMovies.size();
//
//        assertThat(listMoviesCreated, hasSize(sizeList));
//    }
//
//
//    @Test
//    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList() {
//        String informationBook = "Divergent \t| Veronica Roth \t| 2012";
//
//        assertEquals(informationBook, library.showListBooks());
//    }
//
//    @Test
//    public void shouldReturnSuccessfulMessageWhenCheckoutHappen() {
//        String messageExpected = "Thank you! Enjoy the book";
//        String nameBook = "Harry Potter";
//        int yearBook = 2001;
//
//
//        assertEquals(messageExpected, library.checkoutItem(nameBook, yearBook));
//    }
//
//    @Test
//    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
//        String messageExpected = "That book is not available";
//
//        assertEquals(messageExpected, library.checkoutItem("Test Driven Development", 2003));
//    }
//
//    @Test
//    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
//        String nameBook = "Harry Potter";
//        int year = 2001;
//
//        library.checkoutItem(nameBook, year);
//
//        library.searchBookinLibrary(nameBook, year);
//
//        assertEquals("Thank you for returning the book", library.returnItem());
//
//    }
//
//    @Test
//    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
//        String nameBook = "Test Driven Development: By Example";
//        int year = 2002;
//
//        library.searchBookinLibrary(nameBook, year);
//
//        assertEquals("That is not a valid book to return", library.returnItem());
//    }
//
//    @Test
//    public void shouldReturnNameOfBookWhenItIsSearch() {
//        Book bookSearchedInLibrary = library.searchBookinLibrary("Harry Potter", 2001);
//        Book bookSearchedNotInLibrary = library.searchBookinLibrary("Hello Book", 2013);
//
//        assertThat(bookSearchedInLibrary, is(notNullValue()));
//        assertThat(bookSearchedNotInLibrary, is(notNullValue()));
//
//    }

}
