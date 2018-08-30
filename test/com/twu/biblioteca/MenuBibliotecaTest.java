package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuBibliotecaTest {

    @Test
    public void correctOptionMenuTest(){
        assertEquals("Correct option", new MenuBiblioteca().generateMenu(1));

    }

}