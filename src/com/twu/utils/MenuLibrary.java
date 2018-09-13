package com.twu.utils;

import com.twu.library.Library;
import com.twu.login.Login;
import com.twu.login.User;

import java.util.Scanner;

public class MenuLibrary {
    private Library library;
    private Login login;
    private User user;
    public MenuAbstract submenuOption;
    private Dictionary dictionary;
    private PrinterReader printerReader;


    private String nameBook;
    private int yearBook;

    public MenuLibrary() {
    }

    public MenuLibrary(Library library,Login login) {

        this.library = library;
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
        this.login=login;
    }

    public MenuLibrary(Library library) {
        this.library = library;
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
    }

    public String generateMenu(int optionValue) {
        String message = "";
        try {
            if (optionValue == 1) {
                library.showListBooks();
                printerReader.printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionSubMenu()));
                message = dictionary.MESSAGE_CORRECT;
            } else if (optionValue == 2) {
                //Movies
            }else if(optionValue==3) {
                user=login.getCurrentUser();
                printerReader.printTitles(dictionary.TITLE_USER_INFORMATION);
                user.printUserInformation();
            }else if(optionValue==4){
                message = dictionary.MESSAGE_QUIT;
            } else {
                message = dictionary.MESSAGE_INCORRECT;
                printerReader.printMessageReceived(message);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\n" + dictionary.MESSAGE_TRY_CATCH_MENU);
        }
        return message;
    }


    public String generateSubMenu(int optionValue) {
        String message = "";
        submenuOption = new SubMenu(optionValue, library);

        message = submenuOption.performResolve();

        return message;
    }


    private String receivedOptionSubMenu() {
        return new Scanner(System.in).nextLine();
    }


}
