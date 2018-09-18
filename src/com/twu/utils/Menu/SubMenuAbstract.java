package com.twu.utils.Menu;


import com.twu.utils.Menu.optionsSubMenu.Options;

abstract class SubMenuAbstract {
    Options option;

    public SubMenuAbstract() {
    }

    public abstract String returnMessage();

    public String performResolve(){
        String message="";
        message=option.resolve();
        return message;
    }


}
