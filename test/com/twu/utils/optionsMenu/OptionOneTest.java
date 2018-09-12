package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import org.junit.Before;

public class OptionOneTest {
    Dictionary dictionary;
    OptionOne optionOne;
    Library library;

    @Before
    public void setUp(){
        library=new Library();
        optionOne=new OptionOne(library);
    }

}