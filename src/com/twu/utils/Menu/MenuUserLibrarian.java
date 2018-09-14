package com.twu.utils.Menu;

import com.twu.library.ItemsRegistered;
import com.twu.login.Login;
import com.twu.utils.PrinterReader;

import java.util.Scanner;

public class MenuUserLibrarian implements IMenu{
    private PrinterReader printerReader;
    private int optionValue;
    private Login login;
    private ItemsRegistered itemsRegistered;


    public MenuUserLibrarian(Login login) {
        printerReader=new PrinterReader();
        this.login=login;
    }

    @Override
    public void generateMenuUser() {
        String message = "";
        this.optionValue=generateOptionsMenu();

        switch (optionValue){
            case 1:

                break;
            default:
                break;
        }


    }

    @Override
    public int generateOptionsMenu() {
        printerReader.printMenuOptionsLibrarian();
        optionValue = Integer.parseInt(new Scanner(System.in).nextLine());

        return optionValue;
    }
}
