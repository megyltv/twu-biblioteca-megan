package com.twu.utils.Menu;

import com.twu.library.Book;
import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.login.Login;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuUserCostumerTest {
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

        assertEquals(messageReceivedValidOption, new MenuUserCostumer(login).generateSubMenu(4));
        assertEquals(messageReceivedInvalidOption, new MenuUserCostumer(login).generateSubMenu(3));
    }

}