package com.twu.utils;

import com.twu.library.Book;
import com.twu.library.Library;

import java.util.Scanner;

public class MenuLibrary {
    private Library library;
    private Book receivedBook;

    private static final String messageCorrect = "Correct Option";
    private static final String messageQuit = "Quit";
    private static final String messageIncorrect = "Select a valid option";

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
                message = messageCorrect;
            } else if (optionValue == 2) {
                message = messageQuit;
            } else {
                message = messageIncorrect;
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
        String messageReceived = "";
        switch (optionValue) {
            case 1:
                receivedParametersForBook();
                messageReceived = library.checkoutBook(nameBook, yearBook);
                printMessageReceived(messageReceived);
                message = messageCorrect;
                break;
            case 2:
                receivedParametersForBook();
                library.searchBookinLibrary(nameBook, yearBook);
                messageReceived = library.returnBook();
                printMessageReceived(messageReceived);
                message = messageCorrect;
                break;
            case 3:
                message = messageQuit;
                break;
            default:
                message = messageIncorrect;
                printMessageReceived(messageIncorrect);
                break;
        }
        return message;
    }

    private void printSubMenuOptions() {
        System.out.println("\nWhat do you want to do today?\n");
        System.out.println("1. Checkout Book");
        System.out.println("2. Return Book");
        System.out.println("3. Back");
        System.out.print("Select number: ");
    }

    private void printMessageReceived(String message) {
        System.out.println("\n---------------------------\n" +
                message + "\n---------------------------\n");

    }

    private String receivedOptionSubMenu() {
        return new Scanner(System.in).nextLine();
    }

    private void receivedParametersForBook() {
        System.out.print("Name of Book: ");
        nameBook = new Scanner(System.in).nextLine();
        System.out.print("Year of the book: ");
        yearBook = Integer.parseInt(new Scanner(System.in).nextLine());


    }
}
