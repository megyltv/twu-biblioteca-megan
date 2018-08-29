package com.twu.biblioteca;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void showWelcomeMessagetest() {
        assertEquals("Welcome to the Library", new Library().showWelcomeMessage());
    }

    @Test
    public void showListBooks(){
        assertEquals("Test Driven Development: By Example",new Library().showListBooks().get(0).nameBook);
    }

}
