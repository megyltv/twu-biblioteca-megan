package com.twu.utils.Menu;

import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.library.libraries.MovieLibrary;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.Scanner;

public class MenuLibrary {

    private Login login;
    private User user;

    private Dictionary dictionary;
    private PrinterReader printerReader;
    private IMenu iMenu;


    public MenuLibrary(Login login) {
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
        this.login=login;
    }

    public void generateMenu(IMenu iMenu) {
        this.iMenu= iMenu;
        this.iMenu.generateMenuUser();

    }



}
