package com.twu.utils.Menu;

import com.twu.library.libraries.Library;
import com.twu.login.Login;
import com.twu.utils.Menu.optionsMenuLibrarian.OptionOne;
import com.twu.utils.Menu.optionsMenuLibrarian.OptionTwo;

public class MenuLibrarian extends MenuLibrarianAbstract {
    String message="";

    public MenuLibrarian(int i, Library libraryBooks, Library libraryMovies, Login login){
        if(i==1){
            optionsLibrarian=new OptionOne(libraryBooks,libraryMovies);
        }
        if(i==2){
            optionsLibrarian= new OptionTwo(login);
        }

    }

    @Override
    public String returnMessage() {
        message=optionsLibrarian.resolve();
        return message;
    }
}
