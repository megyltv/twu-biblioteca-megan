package com.twu.library.libraries;


import com.twu.library.Book;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;


public class LibraryTest {
    public Library library;
    public List<Book> listBooks;
    Dictionary dictionary;
    public Login login;
    private User user;

    @Before
    public void setUp() {
        user= new User();
        login=new Login(user.createUsers());
        library = new Library(new BookLibrary(login));
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Harry Potter", "JK Rowling", 2001));
        listBooks.add(new Book("Divergent", "Veronica Roth", 2012));
    }

    @Test
    public void shouldShowWelcomeMessageWhenIniatilizingObjectLibrary() {
        assertEquals(dictionary.MESSAGE_WELCOME_TO_LIBRARY, new Library(new BookLibrary(login)).showWelcomeMessage());
    }


    @Test
    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList() {
        String informationBook = "Divergent \t| Veronica Roth \t| 2012";

        assertEquals(informationBook, library.showListItem());
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenCheckoutHappen() {
        String messageExpected = "Thank you! Enjoy the item";
        String nameBook = "Harry Potter";
        login.compareCredentials("123-1236","passwd1");

        assertEquals(messageExpected, library.checkoutItem(nameBook));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
        String messageExpected = "That item is not available";

        assertEquals(messageExpected, library.checkoutItem("Test Driven Development"));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
        String nameBook = "Harry Potter";
        login.compareCredentials("123-1236","passwd1");

        library.checkoutItem(nameBook);

        library.searchIteminLibrary(nameBook);

        assertEquals("Thank you for returning the item", library.checkinItem());

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
        String nameBook = "Test Driven Development: By Example";


        library.searchIteminLibrary(nameBook);

        assertEquals("That is not a valid item to return", library.checkinItem());
    }

    @Test
    public void shouldReturnNameOfBookWhenItIsSearch() {
        Object bookSearchedInLibrary = library.searchIteminLibrary("Harry Potter");
        Object bookSearchedNotInLibrary = library.searchIteminLibrary("Hello Book");

        assertThat(bookSearchedInLibrary, is(notNullValue()));
        assertThat(bookSearchedNotInLibrary, is(notNullValue()));

    }

}
