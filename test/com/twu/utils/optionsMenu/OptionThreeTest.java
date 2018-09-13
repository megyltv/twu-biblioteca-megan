package com.twu.utils.optionsMenu;

import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionThreeTest {
    OptionThree optionThree;
    Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        optionThree = new OptionThree();
        dictionary=new Dictionary();
    }

    @Test
    public void shouldReceiveQuitMessageWhenSelectingOptionThree() {
        String messageExpected = dictionary.MESSAGE_QUIT;

        assertEquals(messageExpected, optionThree.resolve());

    }

}