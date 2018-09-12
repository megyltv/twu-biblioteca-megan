package com.twu.utils;


import com.twu.utils.optionsMenu.Options;

abstract class MenuAbstract {
    Options option;

    public MenuAbstract() {
    }

    public abstract String returnMessage();

    public String performResolve(){
        String message="";
        message=option.resolve();
        return message;
    }


}
