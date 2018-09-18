package com.twu.utils.Menu;

import com.twu.utils.Menu.optionsMenuLibrarian.OptionOne;
import com.twu.utils.Menu.optionsMenuLibrarian.OptionTwo;

public class MenuLibrarian extends MenuLibrarianAbstract {
    String message="";

    public MenuLibrarian(int i, MenuLibrary menuLibrary){
        if(i==1){
            optionsLibrarian=new OptionOne();
        }
        if(i==2){
            optionsLibrarian= new OptionTwo();
        }

    }

    @Override
    public String returnMessage() {
        message=optionsLibrarian.resolve();
        return message;
    }
}
