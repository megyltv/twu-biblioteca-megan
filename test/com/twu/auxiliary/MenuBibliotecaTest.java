package com.twu.auxiliary;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuBibliotecaTest {

    @Test
    public void optionMenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateMenu(3));
        assertEquals("Quit", new MenuBiblioteca().generateMenu(2));
    }

    @Test
    public void optionSubMenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateSubMenu(4));
        assertEquals("Quit", new MenuBiblioteca().generateSubMenu(3));
    }

}