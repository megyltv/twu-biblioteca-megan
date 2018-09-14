package com.twu.utils.Menu;

import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.library.libraries.MovieLibrary;
import com.twu.login.Login;
import com.twu.user.User;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.Scanner;


public class MenuUserCostumer implements IMenu {
    private Dictionary dictionary;
    private int optionValue;
    private PrinterReader printerReader;
    private Login login;
    private User user;
    private Library library;
    public MenuAbstract submenuOption;

    private boolean firstTimeEntering=true;
    private boolean firstTimeEnteringMovie=true;

    public MenuUserCostumer(Login login) {
        this.login=login;
        dictionary=new Dictionary();
        printerReader=new PrinterReader();
    }

    @Override
    public void generateMenuUser() {
        String message = "";
        String typeItem;

        do{
            this.optionValue=generateOptionsMenu();
            try {
                switch (optionValue){
                    case 1:
                        typeItem="Book";
                        showListWithSubmenuOptions(typeItem);
                        break;
                    case 2:
                        typeItem="Movie";
                        showListWithSubmenuOptions(typeItem);
                        break;
                    case 3:
                        user=login.getCurrentUser();
                        printerReader.printTitles(dictionary.TITLE_USER_INFORMATION);
                        user.printUserInformation();
                        message=dictionary.MESSAGE_CORRECT;
                        break;
                    case 4:
                        message = dictionary.MESSAGE_QUIT;
                        System.out.println(library.itemsRegisteredList.get(0).getNameItem());
                        login.logOut();
                        break;
                        default:
                            message = dictionary.MESSAGE_INCORRECT;
                            printerReader.printMessageReceived(message);
                            break;
                }

            } catch (NumberFormatException ex) {
                System.out.println("\n" + dictionary.MESSAGE_TRY_CATCH_MENU);
            }

        }while (message != dictionary.MESSAGE_QUIT);

    }

    @Override
    public int generateOptionsMenu() {
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
