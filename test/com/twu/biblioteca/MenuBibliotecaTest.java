package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuBibliotecaTest {

    @Test
    public void correctOptionMenuTest(){
        assertEquals("Correct option", new MenuBiblioteca().generateMenu(1));
    }

    @Test
    public void incorrectOptionMenu(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateMenu(2));
    }

}