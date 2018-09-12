package com.twu.utils.optionsMenu;

import com.twu.utils.Dictionary;

public class OptionDefault implements Options {
    private Dictionary dictionary;

    @Override
    public String resolve(){
        String message=dictionary.messageIncorrect;
        return message;
    }
}
