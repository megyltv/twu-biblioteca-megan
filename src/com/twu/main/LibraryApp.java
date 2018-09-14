package com.twu.main;

import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import com.twu.utils.Menu.MenuLibrary;
import com.twu.library.libraries.Library;
import com.twu.utils.Menu.MenuUserCostumer;
import com.twu.utils.Menu.MenuUserLibrarian;
import com.twu.utils.PrinterReader;

public class LibraryApp {

    public static void main(String[] args) {

        MenuLibrary menu;
        User user = new User();
        Login login = new Login(user.createUsers());
        PrinterReader printerReader = new PrinterReader();
        Dictionary dictionary = new Dictionary();
        Library library=new Library();

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
                    if(login.getCurrentUser().getRole()== User.Role.CUSTOMER){
                        menu.generateMenu(new MenuUserCostumer(login));
                    }else{
                        menu.generateMenu(new MenuUserLibrarian(login));
                    }

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
