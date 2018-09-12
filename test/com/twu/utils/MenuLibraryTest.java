package com.twu.utils;

import com.twu.library.Book;
import com.twu.library.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuLibraryTest {
    public Library library;
    public List<Book> listBooks;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void SetUp() {
        library = new Library();
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example", "Kent Beck", 2003));
        listBooks.add(new Book("The C Programming Language", "Dennis Ritchie", 1978));

    }

    @Test
    public void shouldReturnMessageWhenSendingOptionToMenu() {
        String messageReceivedValidOption = "Select a valid option";
        String messageReceivedInvalidOption = "Quit";

        assertEquals(messageReceivedValidOption, new MenuLibrary(library).generateMenu(3));
        assertEquals(messageReceivedInvalidOption, new MenuLibrary(library).generateMenu(2));
    }

    @Test
    public void shouldReturnMessageWhenSendingOptionToSubMenu() {
        String messageReceivedValidOption = "Select a valid option";
        String messageReceivedInvalidOption = "Quit";

        assertEquals(messageReceivedValidOption, new MenuLibrary(library).generateSubMenu(4));
        assertEquals(messageReceivedInvalidOption, new MenuLibrary(library).generateSubMenu(3));
    }

    @Test
    public void shouldReturnMenuShowedInConsoleWhenTheMenuIsGenerated() {
        MenuLibrary menu = new MenuLibrary();
        menu.printMenuOptions();

        System.setOut(new PrintStream(outContent));
    }

}