package com.twu.main;

import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import com.twu.utils.Menu.MenuLibraryPrincipal;
import com.twu.library.libraries.Library;
import com.twu.utils.PrinterReader;

public class LibraryApp {

    public static void main(String[] args) {

        MenuLibraryPrincipal menu=new MenuLibraryPrincipal();
        User user = new User();
        Login login = new Login(user.createUsers());
        PrinterReader printerReader = new PrinterReader();
        Dictionary dictionary = new Dictionary();
        Library library=new Library();

        String loginUserInformation="";
        String[] loginUserInformationSeparated;
        boolean loginStatus;
        String messageIncorrect;
        boolean menuFirst=true;


        do{
            printerReader.printTitles(dictionary.MESSAGE_LOGIN);
            loginUserInformation=printerReader.receivedParametersForLogin();
            loginUserInformationSeparated=loginUserInformation.split("/");

            loginStatus=login.compareCredentials(loginUserInformationSeparated[0],loginUserInformationSeparated[1]);

            if(menuFirst){
                menu=new MenuLibraryPrincipal(login);
                menuFirst=false;
            }


            if(loginStatus){
                printerReader.printTitles(library.showWelcomeMessage());
                try {
                    if(login.getCurrentUser().getRole()== User.Role.CUSTOMER){
                        menu.generateMenuCostumer();
                    }else{
                        menu.generateMenuLibrarian();
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
