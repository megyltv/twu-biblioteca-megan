package com.twu.biblioteca;

import com.twu.auxiliary.MenuBiblioteca;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuBibliotecaTest {

    @Test
    public void incorrectOptionMenu(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateMenu(3));
    }

    @Test
    public void optionSubMenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca().generateSubMenu(4));
        assertEquals("Quit", new MenuBiblioteca().generateSubMenu(3));
    }
}