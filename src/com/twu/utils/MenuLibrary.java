package com.twu.utils;

import com.twu.library.BookLibrary;
import com.twu.library.Library;
import com.twu.library.MovieLibrary;
import com.twu.login.Login;
import com.twu.user.User;

import java.util.Scanner;

public class MenuLibrary {
    private Library library;
    private Login login;
    private User user;
    public MenuAbstract submenuOption;
    private Dictionary dictionary;
    private PrinterReader printerReader;
    private boolean firstTimeEntering=true;
    private boolean firstTimeEnteringMovie=true;
    private int optionValue;

    public MenuLibrary(Login login) {
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
        this.login=login;
    }

    public void generateMenuCustomer() {
        String message = "";
        String typeItem;

        this.optionValue=generateOptionsMenu();

        while (message != dictionary.MESSAGE_QUIT){
            try {

                if (optionValue == 1) {
                    typeItem="Book";
                    showListWithSubmenuOptions(typeItem);
                }
                if (optionValue == 2) {
                    typeItem="Movie";
                    showListWithSubmenuOptions(typeItem);
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
                    break;
                }
                if (optionValue>4){
                    message = dictionary.MESSAGE_INCORRECT;
                    printerReader.printMessageReceived(message);
                }
            } catch (NumberFormatException ex) {
                System.out.println("\n" + dictionary.MESSAGE_TRY_CATCH_MENU);
            }

            this.optionValue=generateOptionsMenu();

        }
    }

    private int generateOptionsMenu(){
            printerReader.printMenuOptionsCustomer();
            optionValue = Integer.parseInt(new Scanner(System.in).nextLine());

        return optionValue;
    }

    public String generateSubMenu(int optionValue) {
        String message = "";
        submenuOption = new SubMenu(optionValue, library);

        message = submenuOption.performResolve();

        return message;
    }

    private void askIfItIsFirstTimeEntering(){

        if(firstTimeEntering&&optionValue==1){
            library=new Library(new BookLibrary(login));
            firstTimeEntering=false;
        }
        if(firstTimeEnteringMovie&&optionValue==2){
            library=new Library(new MovieLibrary(login));
            firstTimeEnteringMovie=false;
        }
    }

    private String showListWithSubmenuOptions(String typeItem){
        askIfItIsFirstTimeEntering();
        library.showListItem();
        printerReader.printSubMenuOptions(typeItem);
        generateSubMenu(Integer.parseInt(printerReader.receivedOptionForMenuOrSubMenu()));

        return dictionary.MESSAGE_CORRECT;
    }

}
