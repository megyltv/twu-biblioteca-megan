package com.twu.utils;

import com.twu.library.Book;
import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.login.Login;
import com.twu.utils.Menu.MenuLibraryPrincipal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MenuLibraryPrincipalTest {
    public Library library;
    public List<Book> listBooks;
    Login login;
    private MenuLibraryPrincipal menuLibrary;

    @Mock
    MenuLibraryPrincipal menuLibraryMock;

    @InjectMocks
    MenuLibraryPrincipal menuLibraryMockInject;

    @Before
    public void SetUp() {
        login = new Login();
        library = new Library(new BookLibrary(),login);;
        listBooks = new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example", "Kent Beck", 2003));
        listBooks.add(new Book("The C Programming Language", "Dennis Ritchie", 1978));

    }

    @Test
    public void shouldReturnMessageQuitWhenSendNumberFourInMenu(){
        String data="4";
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            Scanner scanner = new Scanner(System.in);

        }finally {
            System.setIn(stdin);
        }

    }



}