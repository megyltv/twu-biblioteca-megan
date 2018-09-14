package com.twu.utils.Menu;

import com.twu.library.ItemsRegistered;
import com.twu.library.libraries.Library;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.List;
import java.util.Scanner;

public class MenuUserLibrarian implements IMenu {
    private PrinterReader printerReader;
    private int optionValue;
    private Login login;
    private Dictionary dictionary;
    private ItemsRegistered itemsRegistered;
    private Library library;
    List<ItemsRegistered>item;


    public MenuUserLibrarian(Login login) {
        printerReader = new PrinterReader();
        this.login = login;
    }

    @Override
    public void generateMenuUser() {
        String message = "";

        do{
            this.optionValue = generateOptionsMenu();
            switch (optionValue) {
                case 1:
                    listItemsRegistered();
                    break;
                case 2:
                    message = dictionary.MESSAGE_QUIT;
                    login.logOut();
                    break;
                default:
                    message = dictionary.MESSAGE_INCORRECT;
                    printerReader.printMessageReceived(message);
                    break;
            }

        }while (message != dictionary.MESSAGE_QUIT);
    }

    @Override
    public int generateOptionsMenu() {
        printerReader.printMenuOptionsLibrarian();
        optionValue = Integer.parseInt(new Scanner(System.in).nextLine());

        return optionValue;
    }

    private void listItemsRegistered(){
        try {
            item =library.itemsRegisteredList;
            System.out.println(item.get(0).getNameItem());
            library.showItemsRegistered(library.getCurrentLisItemsRegistered());

        }catch (NullPointerException e){
            System.out.println("Not items registered");
        }
    }
}
