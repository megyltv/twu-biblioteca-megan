package com.twu.utils.Menu.optionsSubMenu;

import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class OptionOneTest {
    private OptionOne optionOne;
    private Library library;
    private Login login;
    private Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        User user = new User();
        login = new Login(user.createUsers());

        login.compareCredentials("123-1236","passwd1");

        library=new Library(new BookLibrary(),login);
        optionOne=new OptionOne(library);
    }

    @Test
    public void shouldReturnMessageOfCorrectOptionWhenSelectingCheckOutOptionInMenu(){
        String messageExpected=dictionary.MESSAGE_CORRECT;
        String inputNameOfItem="Harry Potter";
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(inputNameOfItem.getBytes()));

        String messageReceived=optionOne.resolve();

        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);

        assertEquals(messageExpected,messageReceived);
    }
}