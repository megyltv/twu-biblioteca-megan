package com.twu.utils.Menu.optionsMenuLibrarian;

import com.twu.login.Login;
import com.twu.utils.Dictionary;

public class OptionTwo implements IOptionsLibrarian{
    private String message="";
    private Dictionary dictionary;
    private Login login;

    public OptionTwo(Login login){
        this.login=login;
    }

    @Override
    public String resolve() {
        message = dictionary.MESSAGE_QUIT;
        login.logOut();

        return message;
    }
}
