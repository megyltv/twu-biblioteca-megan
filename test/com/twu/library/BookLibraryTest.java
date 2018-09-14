package com.twu.library;

import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
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
        login=new Login();
        library = new Library(new BookLibrary(login));
        bookLibrary=new BookLibrary(login);
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


        assertEquals(messageExpected, bookLibrary.checkoutItem(nameBook));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInCheckout() {
        String messageExpected = dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        assertEquals(messageExpected, bookLibrary.checkoutItem("Test Driven Development"));
    }

    @Test
    public void shouldReturnSuccessfulMessageWhenTheBookIsReturned() {
        String nameBook = "Harry Potter";
        int year = 2001;
        String messageExpected=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;

        bookLibrary.checkoutItem(nameBook);

        bookLibrary.searchItem(nameBook);

        assertEquals(messageExpected, bookLibrary.checkinItem());

    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenErrorInReturn() {
        String nameBook = "Test Driven Development: By Example";
        int year = 2002;
        String messageExpected=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_IN;

        bookLibrary.searchItem(nameBook);

        assertEquals("That is not a valid item to return", bookLibrary.checkinItem());
    }

    @Test
    public void shouldReturnBookNotNullWhenItIsSearch() {
        Book bookSearchedInLibrary = (Book) bookLibrary.searchItem("Harry Potter");

        assertThat(bookSearchedInLibrary, is(notNullValue()));


    }

    @Test
    public void shouldReturnNotNullWhenItIsSearchAndNotExistsInLibrary(){
        Book bookSearchedNotInLibrary = (Book)bookLibrary.searchItem("Hello Book");

        assertThat(bookSearchedNotInLibrary, is(notNullValue()));
    }

}