package com.twu.library;

import com.twu.login.Login;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class BookLibraryTest {
    public Library library;
    public BookLibrary bookLibrary;
    public Login login;
    private Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        login=new Login();
        bookLibrary=new BookLibrary(library.listBooks,login);
    }

    @Test
    public void shouldReturnDataOfLastBookOfTheListOfBooksWhenSendAList() {
        String informationBook = "Divergent \t| Veronica Roth \t| 2012";

        assertEquals(informationBook, bookLibrary.showListItem());
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenCheckoutHappen() {
        String messageExpected = dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_OUT;
        String nameBook = "Harry Potter";
        int yearBook = 2001;


        assertEquals(messageExpected, bookLibrary.checkoutItem(nameBook, yearBook));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
        String messageExpected = dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        assertEquals(messageExpected, bookLibrary.checkoutItem("Test Driven Development", 2003));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
        String nameBook = "Harry Potter";
        int year = 2001;
        String messageExpected=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;

        bookLibrary.checkoutItem(nameBook, year);

        bookLibrary.searchItem(nameBook, year);

        assertEquals(messageExpected, bookLibrary.checkinItem());

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
        String nameBook = "Test Driven Development: By Example";
        int year = 2002;
        String messageExpected=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_IN;

        bookLibrary.searchItem(nameBook, year);

        assertEquals("That is not a valid item to return", bookLibrary.checkinItem());
    }

    @Test
    public void shouldReturnBookNotNullWhenItIsSearch() {
        Book bookSearchedInLibrary = (Book) bookLibrary.searchItem("Harry Potter", 2001);
        Book bookSearchedNotInLibrary = (Book)bookLibrary.searchItem("Hello Book", 2013);

        assertThat(bookSearchedInLibrary, is(notNullValue()));
        assertThat(bookSearchedNotInLibrary, is(notNullValue()));

    }

}