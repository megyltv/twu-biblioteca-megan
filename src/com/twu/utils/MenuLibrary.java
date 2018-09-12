package com.twu.utils;

import com.twu.library.Library;

import java.util.Scanner;

public class MenuLibrary {
    private Library library;
    public MenuAbstract submenuOption;
    ;
    private Dictionary dictionary;
    private PrinterReader printerReader;

    private String nameBook;
    private int yearBook;

    public MenuLibrary() {
    }

    public MenuLibrary(Library library) {

        this.library = library;
        printerReader = new PrinterReader();
        dictionary = new Dictionary();
    }

    public String generateMenu(int optionValue) {
        String message = "";
        try {
            if (optionValue == 1) {
                library.showListBooks();
                printerReader.printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionSubMenu()));
                message = dictionary.messageCorrect;
            } else if (optionValue == 2) {
                message = dictionary.messageQuit;
            } else {
                message = dictionary.messageIncorrect;
                printerReader.printMessageReceived(message);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\n" + dictionary.messageTryCatchMenu);
        }
        return message;
    }


    public String generateSubMenu(int optionValue) {
        String message = "";
        submenuOption = new SubMenu(optionValue, library);

        message = submenuOption.performResolve();

        return message;
    }


    private String receivedOptionSubMenu() {
        return new Scanner(System.in).nextLine();
    }


}
