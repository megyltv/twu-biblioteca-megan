package com.twu.library.libraries;

import com.twu.library.Movie;
import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.library.libraries.MovieLibrary;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

public class MovieLibraryTest {
    public MovieLibrary movieLibrary;
    public Library library;
    public Login login;
    private Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        library=new Library(new BookLibrary(login));
        login = new Login();
        movieLibrary = new MovieLibrary(login);
    }

    @Test
    public void shouldReturnDetailedOfLastMoviesWhenIsListed(){
        String messageExpected="Batman \t| Christopher Nolan \t| 2008 \t| 8";

        assertEquals(messageExpected,movieLibrary.showListItem());

    }

    @Test
    public void shouldReturnSuccessfullMessageWhenMovieIsCheckOut(){
        String nameMovie="Titanic";
        String messageExpected=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;

        assertEquals(messageExpected,movieLibrary.checkoutItem(nameMovie));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenMovieIsNotCheckout(){
        String nameMovie="Harry Potter";
        String messageExpected=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        assertEquals(messageExpected,movieLibrary.checkoutItem(nameMovie));
    }

    @Test
    public void shouldReturnSuccesdfulMessageWhenMovieIsReturned(){
        String nameMovie="Titanic";
        String messageExpected=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;

        movieLibrary.checkoutItem(nameMovie);
        movieLibrary.searchItem(nameMovie);

        assertEquals(messageExpected,movieLibrary.checkinItem());
    }

    @Test
    public void shouldReturnUnSuccessfulMessageWhenErrorInReturning(){
        String nameMovie="Harry Potter";
        String messgeExpected=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_IN;

        movieLibrary.searchItem(nameMovie);

        assertEquals(messgeExpected,movieLibrary.checkinItem());
    }



    @Test
    public void shouldReturnMovieNotNullWhenItIsSearched(){
        Movie movieSearchedExistingInLibrary=(Movie) movieLibrary.searchItem("Titanic");
        assertThat(movieSearchedExistingInLibrary,is(notNullValue()));
    }

    @Test
    public void shouldReturnMovieNotNullWhenItIsSearchedAndNotInLibrary(){
        Movie movieSearchedNotExistingInLibrary=(Movie)movieLibrary.searchItem("Harry Potter");
        assertThat(movieSearchedNotExistingInLibrary,is(notNullValue()));
    }

}