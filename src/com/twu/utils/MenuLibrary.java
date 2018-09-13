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

    int optionValue;

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

    public void generateMenu(int optionValue) {
        String message = "";
        this.optionValue=optionValue;
        String typeItem;
        do{
            try {
                if (optionValue == 1) {
                    typeItem="Book";
                    library.showListBooks();
                    printerReader.printSubMenuOptions(typeItem);
                    generateSubMenu(Integer.parseInt(printerReader.receivedOptionForMenuOrSubMenu()));
                    message = dictionary.MESSAGE_CORRECT;
                }
                if (optionValue == 2) {
                    //Movies
                    typeItem="Movie";
                    printerReader.printSubMenuOptions(typeItem);

                }
                if(optionValue==3) {
                    user=login.getCurrentUser();
                    printerReader.printTitles(dictionary.TITLE_USER_INFORMATION);
                    user.printUserInformation();
                    message=dictionary.MESSAGE_CORRECT;
                }
                if(optionValue==4){
                    message = dictionary.MESSAGE_QUIT;
                    login.logOut();
                }
                if (optionValue>4){
                    message = dictionary.MESSAGE_INCORRECT;
                    printerReader.printMessageReceived(message);
                }
            } catch (NumberFormatException ex) {
                System.out.println("\n" + dictionary.MESSAGE_TRY_CATCH_MENU);
            }

            optionValue=generateOptionsMenu(message);

        }while (message != dictionary.MESSAGE_QUIT);
    }

    private int generateOptionsMenu(String message){
        System.out.println(message);
        if(message!=dictionary.MESSAGE_QUIT) {
            printerReader.printMenuOptions();
            optionValue = Integer.parseInt(new Scanner(System.in).nextLine());
        }
        return optionValue;
    }


    public String generateSubMenu(int optionValue) {
        String message = "";
        submenuOption = new SubMenu(optionValue, library);

        message = submenuOption.performResolve();

        return message;
    }


}
