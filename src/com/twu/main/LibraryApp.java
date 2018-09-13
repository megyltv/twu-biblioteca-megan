package com.twu.main;

import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;
import com.twu.library.Library;
import com.twu.utils.PrinterReader;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {
        Library library = new Library();
        MenuLibrary menu;
        Login login = new Login();
        PrinterReader printerReader = new PrinterReader();
        Dictionary dictionary = new Dictionary();

        int optionMenu;
        String message = "";
        String loginUserInformation="";
        String[] loginUserInformationSeparated;
        boolean loginStatus;
        String messageIncorrect;

        loginUserInformation=printerReader.receivedParametersForLogin();
        loginUserInformationSeparated=loginUserInformation.split("/");

        loginStatus=login.compareCredentials(loginUserInformationSeparated[0],loginUserInformationSeparated[1]);

        menu=new MenuLibrary(library,login);

        if(loginStatus){
            do {
                printerReader.printTitles(library.showWelcomeMessage());
                try {
                    printerReader.printMenuOptions();
                    optionMenu = Integer.parseInt(new Scanner(System.in).nextLine());
                    message = menu.generateMenu(optionMenu);
                } catch (NumberFormatException ex) {
                    System.out.println(dictionary.MESSAGE_TRY_CATCH_MENU);
                }

            } while (message != dictionary.MESSAGE_QUIT);
        }else{
            messageIncorrect=login.showMessageIfIncorrect(loginStatus);
            printerReader.printMessageReceived(messageIncorrect);
        }

    }
}
