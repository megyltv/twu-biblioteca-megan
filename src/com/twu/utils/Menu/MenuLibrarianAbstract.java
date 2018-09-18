package com.twu.utils.Menu;

import com.twu.utils.Menu.optionsMenuLibrarian.IOptionsLibrarian;

abstract class MenuLibrarianAbstract {
    IOptionsLibrarian optionsLibrarian;

    public MenuLibrarianAbstract() {
    }

    public abstract String returnMessage();

    public String performResolve(){
        String message="";
        message=optionsLibrarian.resolve();
        return message;
    }

}
