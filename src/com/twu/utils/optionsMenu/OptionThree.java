package com.twu.utils.optionsMenu;

import com.twu.utils.Dictionary;

public class OptionThree implements Options {
    private Dictionary dictionary;

    public OptionThree(){ }

    @Override
    public String resolve(){
        String message;
        message = dictionary.messageQuit;
        return message;
    }
}
