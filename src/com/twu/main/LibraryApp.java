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
        MenuLibrary menu = new MenuLibrary(library);
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

        if(loginStatus){
            do {
                System.out.println("\n" + library.showWelcomeMessage() + "\n");
                try {
                    printerReader.printMenuOptions();
                    optionMenu = Integer.parseInt(new Scanner(System.in).nextLine());
                    message = menu.generateMenu(optionMenu);
                } catch (NumberFormatException ex) {
                    System.out.println(dictionary.messageTryCatchMenu);
                }

            } while (message != dictionary.messageQuit);
        }else{
            messageIncorrect=login.showMessageIfIncorrect(loginStatus);
            printerReader.printMessageReceived(messageIncorrect);
        }

    }
}
