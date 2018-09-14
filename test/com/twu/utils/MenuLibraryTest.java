package com.twu.utils;

import com.twu.library.Book;
import com.twu.library.BookLibrary;
import com.twu.library.Library;
import com.twu.login.Login;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuLibraryTest {
    public Library library;
    public List<Book> listBooks;
    Login login;

    @Before
    public void SetUp() {
        login = new Login();
        library = new Library(new BookLibrary(login));;
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example", "Kent Beck", 2003));
        listBooks.add(new Book("The C Programming Language", "Dennis Ritchie", 1978));

    }

    @Test
    public void shouldReturnMessageWhenSendingOptionToSubMenu() {
        String messageReceivedValidOption = "Select a valid option";
        String messageReceivedInvalidOption = "Quit";

        assertEquals(messageReceivedValidOption, new MenuLibrary(login).generateSubMenu(4));
        assertEquals(messageReceivedInvalidOption, new MenuLibrary(login).generateSubMenu(3));
    }


}