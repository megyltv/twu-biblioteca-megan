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

    @Test
    public void correctOptionSubmenuTest(){
        assertEquals("Correct option", new MenuBiblioteca().generateSubMenu(1));
    }

    @Test
    public void incorrectOptionSubmenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateSubMenu(4));
    }

}