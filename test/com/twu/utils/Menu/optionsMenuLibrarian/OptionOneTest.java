package com.twu.utils.Menu.optionsMenuLibrarian;

import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.library.libraries.MovieLibrary;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class OptionOneTest {
    private Library libraryBooks;
    private Library libraryMovies;
    private Login login;
    private OptionOne optionOne;
    private Dictionary dictionary;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Before
    public void setUp() throws Exception {
        User user = new User();
        login = new Login(user.createUsers());

        login.compareCredentials("123-1236","passwd1");
        libraryBooks = new Library(new BookLibrary(), login);
        libraryMovies = new Library(new MovieLibrary(), login);

        optionOne=new OptionOne(libraryBooks,libraryMovies);
    }

    @Test
    public void shouldReturnMessageOfCorrectIfOptionWasCorrectInSubMenu(){

        assertEquals(dictionary.MESSAGE_CORRECT,optionOne.resolve());
    }

    @Test
    public void shouldPrintMessageOfItemsNotRegisteredWhenListEmpty(){
        PrinterReader printerReader = new PrinterReader();
        optionOne.resolve();

        System.setOut(new PrintStream(outContent));
    }

}