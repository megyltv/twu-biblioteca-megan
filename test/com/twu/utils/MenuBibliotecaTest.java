package com.twu.utils;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuBibliotecaTest {
    public Library library;
    public ArrayList<Book> listBooks;

    @Before
    public void SetUp(){
        library= new Library();
        listBooks=new ArrayList<Book>();
        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2003));
        listBooks.add(new Book("The C Programming Language","Dennis Ritchie",1978));
    }

    @Test
    public void optionMenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca(library).generateMenu(3));
        assertEquals("Quit", new MenuBiblioteca(library).generateMenu(2));
    }

    @Test
    public void optionSubMenuTest(){
        assertEquals("Select a valid option", new MenuBiblioteca(library).generateSubMenu(4));
        assertEquals("Quit", new MenuBiblioteca(library).generateSubMenu(3));
    }

}