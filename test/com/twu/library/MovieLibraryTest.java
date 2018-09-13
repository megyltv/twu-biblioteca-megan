package com.twu.library;

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
        library=new Library();
        login = new Login();
        movieLibrary = new MovieLibrary(library.listMovies,login);
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

        assertEquals(messageExpected,movieLibrary.checkoutItem(nameMovie,0));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenMovieIsNotCheckout(){
        String nameMovie="Harry Potter";
        String messageExpected=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        assertEquals(messageExpected,movieLibrary.checkoutItem(nameMovie,0));
    }

    @Test
    public void shouldReturnSuccesdfulMessageWhenMovieIsReturned(){
        String nameMovie="Titanic";
        String messageExpected=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;

        movieLibrary.checkoutItem(nameMovie,0);
        movieLibrary.searchItem(nameMovie,0);

        assertEquals(messageExpected,movieLibrary.checkinItem());
    }



    @Test
    public void shouldReturnMovieNotNullWhenItIsSearched(){
        Movie movieSearchedExistingInLibrary=(Movie) movieLibrary.searchItem("Titanic",0);
        assertThat(movieSearchedExistingInLibrary,is(notNullValue()));
    }

    @Test
    public void shouldReturnMovieNotNullWhenItIsSearchedAndNotInLibrary(){
        Movie movieSearchedNotExistingInLibrary=(Movie)movieLibrary.searchItem("Harry Potter",0);
        assertThat(movieSearchedNotExistingInLibrary,is(notNullValue()));
    }

}