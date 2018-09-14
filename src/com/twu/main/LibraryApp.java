package com.twu.main;

import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;
import com.twu.library.Library;
import com.twu.utils.PrinterReader;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        MenuLibrary menu;
        Login login = new Login();
        PrinterReader printerReader = new PrinterReader();
        Dictionary dictionary = new Dictionary();
        Library library=new Library();

        int optionMenu;
        String message = "";
        String loginUserInformation="";
        String[] loginUserInformationSeparated;
        boolean loginStatus;
        String messageIncorrect;


        do{
            printerReader.printTitles(dictionary.MESSAGE_LOGIN);
            loginUserInformation=printerReader.receivedParametersForLogin();
            loginUserInformationSeparated=loginUserInformation.split("/");

            loginStatus=login.compareCredentials(loginUserInformationSeparated[0],loginUserInformationSeparated[1]);

            menu=new MenuLibrary(login);

            if(loginStatus){
                printerReader.printTitles(library.showWelcomeMessage());
                try {
                    printerReader.printMenuOptions();
                    optionMenu = Integer.parseInt(printerReader.receivedOptionForMenuOrSubMenu());
                    menu.generateMenu(optionMenu);
                } catch (NumberFormatException ex) {
                    System.out.println(dictionary.MESSAGE_TRY_CATCH_MENU);
                }
            }else{
                messageIncorrect=login.showMessageIfIncorrect(loginStatus);
                printerReader.printMessageReceived(messageIncorrect);
            }
            loginStatus=false;

        }while (!loginStatus);

    }
}
