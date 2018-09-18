package com.twu.utils.Menu;

import com.twu.library.Items;
import com.twu.library.libraries.BookLibrary;
import com.twu.library.libraries.Library;
import com.twu.library.libraries.MovieLibrary;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuLibrary {

    private Login login;

    private Dictionary dictionary;
    private PrinterReader printerReader;

    private Library libraryBooks;
    private Library libraryMovies;
    private int optionValue;

    private boolean firstTimeEntering = true;
    private List<Items> itemsRegisteredList;

    public MenuLibrary() {
    }

    public MenuLibrary(Login login) {
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
        this.login = login;
        itemsRegisteredList = new ArrayList<Items>();
    }

    public void generateMenuCostumer() {
        SubMenuAbstract submenuOption;
        String message = "";
        String typeItem;
        int optionValorSubmenu;
        askIfItIsFirstTimeEntering();

        do {
            this.optionValue = generateOptionsMenu();
            try {
                switch (optionValue) {
                    case 1:
                        typeItem = "Book";

                        libraryBooks.showListItem();
                        optionValorSubmenu=generateOptionsSubmenu(typeItem);
                        submenuOption = new SubMenu(optionValorSubmenu, libraryBooks);

                        message = submenuOption.performResolve();
                        break;
                    case 2:
                        typeItem = "Movie";

                        libraryMovies.showListItem();
                        optionValorSubmenu=generateOptionsSubmenu(typeItem);
                        submenuOption = new SubMenu(optionValorSubmenu, libraryMovies);

                        message = submenuOption.performResolve();
                        break;
                    case 3:
                        printerReader.printTitles(dictionary.TITLE_USER_INFORMATION);
                        printerReader.printUserInformation(login.getCurrentUser());
                        message = dictionary.MESSAGE_CORRECT;
                        break;
                    case 4:
                        message = dictionary.MESSAGE_QUIT;
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
        } while (message != dictionary.MESSAGE_QUIT);
    }

    public void generateMenuLibrarian() {
        String message = "";

        do {
            printerReader.printMenuOptionsLibrarian();
            optionValue = Integer.parseInt(new Scanner(System.in).nextLine());
            switch (optionValue) {
                case 1:
                    try {
                        showListsOfItemsRegistered();
                        message = dictionary.MESSAGE_CORRECT;
                    } catch (NullPointerException e) {
                        System.out.println("No hay items registrados");
                        message = dictionary.MESSAGE_CORRECT;
                    }
                    break;
                case 2:
                    message = dictionary.MESSAGE_QUIT;
                    login.logOut();
                    break;
                default:
                    break;
            }
        } while (message != dictionary.MESSAGE_QUIT);

    }

    private int generateOptionsMenu() {
        printerReader.printMenuOptionsCustomer();
        optionValue = Integer.parseInt(new Scanner(System.in).nextLine());

        return optionValue;
    }

    private int generateOptionsSubmenu(String typeItem){
        int optionValueSubmenu;

        printerReader.printSubMenuOptions(typeItem);
        optionValueSubmenu = Integer.parseInt(printerReader.receivedOptionForMenuOrSubMenu());

        return optionValueSubmenu;
    }


    private void askIfItIsFirstTimeEntering() {

        if (firstTimeEntering) {
            libraryBooks = new Library(new BookLibrary(), login);
            libraryMovies = new Library(new MovieLibrary(), login);
            firstTimeEntering = false;
        }
    }

    private void showListsOfItemsRegistered() {

        if (!libraryBooks.getCurrentList().isEmpty()) {
            itemsRegisteredList = libraryBooks.getCurrentList();
            libraryBooks.showListOfItemsRegistered(itemsRegisteredList,dictionary.TITLE_BOOKS);

        }
        if (!libraryMovies.getCurrentList().isEmpty()) {
            itemsRegisteredList = libraryMovies.getCurrentList();
            libraryMovies.showListOfItemsRegistered(itemsRegisteredList,dictionary.TITLE_MOVIES);
        }

    }

}
