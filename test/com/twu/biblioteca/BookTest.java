package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book newBook=new Book("Test Driven Development: By Example","Kent Beck",2002);

    @Test
    public void changeCheckoutTest(){
        assertEquals(false,newBook.changeCheckout(newBook).checkout);
        assertEquals(true,newBook.changeCheckout(newBook).checkout);


    }

}