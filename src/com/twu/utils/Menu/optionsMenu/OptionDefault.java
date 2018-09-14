package com.twu.utils.Menu.optionsMenu;

import com.twu.utils.Dictionary;

public class OptionDefault implements Options {
    private Dictionary dictionary;

    @Override
    public String resolve(){
        String message=dictionary.MESSAGE_INCORRECT;
        return message;
    }
}
