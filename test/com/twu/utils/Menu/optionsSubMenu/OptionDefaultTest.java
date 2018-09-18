package com.twu.utils.Menu.optionsSubMenu;

import com.twu.utils.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OptionDefaultTest {
    OptionDefault optionDefault;
    Dictionary dictionary;

    @Before
    public void setUp() throws Exception {
        optionDefault=new OptionDefault();
        dictionary=new Dictionary();
    }

    @Test
    public void shouldReturnMessageOfIncorrectWhenSelectingOtherOption(){
        String messageExpected= dictionary.MESSAGE_INCORRECT;

        assertEquals(messageExpected,optionDefault.resolve());
    }

}