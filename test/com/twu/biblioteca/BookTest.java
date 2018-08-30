package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void changeCheckoutTest(){
        Boolean checkoutSend=false;
        assertEquals(false,new Book().changeCheckout(checkoutSend));
        assertEquals(true,new Book().changeCheckout(!checkoutSend));

    }

}