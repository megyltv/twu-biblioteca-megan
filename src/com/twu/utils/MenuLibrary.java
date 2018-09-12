package com.twu.utils;

import com.twu.library.Library;

import java.util.Scanner;

public class MenuLibrary {
    private Library library;
    public MenuAbstract submenuOption;;
    private Dictionary dictionary;

    private String nameBook;
    private int yearBook;

    public MenuLibrary() {
    }

    public MenuLibrary(Library library) {
        this.library = library;
    }

    public String generateMenu(int optionValue) {
        String message = "";
        try {
            if (optionValue == 1) {
                library.showListBooks();
                printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionSubMenu()));
                message = dictionary.messageCorrect;
            } else if (optionValue == 2) {
                message = dictionary.messageQuit;
            } else {
                message = dictionary.messageIncorrect;
                printMessageReceived(message);
            }
        } catch (NumberFormatException ex) {
            System.out.println("\nSelect a valid option. Only numbers, please!");
        }
        return message;
    }

    public void printMenuOptions() {
        System.out.println("\nSelect number:");
        System.out.println("1. List Books");
        System.out.println("2. Quit");
        System.out.print("Option: ");
    }

    public String generateSubMenu(int optionValue) {
        String message = "";
        submenuOption = new SubMenu(optionValue,library);

        message=submenuOption.performResolve();

        return message;
    }

    private void printSubMenuOptions() {
        System.out.println("\nWhat do you want to do today?\n");
        System.out.println("1. Checkout Book");
        System.out.println("2. Return Book");
        System.out.println("3. Back");
        System.out.print("Select number: ");
    }

    public void printMessageReceived(String message) {
        System.out.println("\n---------------------------\n" +
                message + "\n---------------------------\n");

    }

    private String receivedOptionSubMenu() {
        return new Scanner(System.in).nextLine();
    }

    public String receivedParametersForBook() {
        System.out.print("Name of Book: ");
        nameBook = new Scanner(System.in).nextLine();
        System.out.print("Year of the book: ");
        yearBook = Integer.parseInt(new Scanner(System.in).nextLine());

        return nameBook+"-"+yearBook;

    }
}
