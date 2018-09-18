package com.twu.utils.Menu.optionsSubMenu;

import com.twu.utils.Dictionary;

public class OptionThree implements Options {
    private Dictionary dictionary;

    public OptionThree(){ }

    @Override
    public String resolve(){
        String message;
        message = dictionary.MESSAGE_QUIT;
        return message;
    }
}
