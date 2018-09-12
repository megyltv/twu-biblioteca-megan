package com.twu.login;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UserTest {
    User user;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        user = new User("123-1234", "passwd", "Mary", "mar@ej.com", "20983950");
    }

    @Test
    public void shouldReturnInformationOfUserPrintedWhenTheMethodIsCalled() {
        user.printUserInformation();

        System.setOut(new PrintStream(outContent));
    }
}