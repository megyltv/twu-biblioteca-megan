package com.twu.utils;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.Scanner;

public class MenuBiblioteca {
    protected Library library;
    protected Book receivedBook;
    protected String message="";
    protected String messageReceived="";

    private String nameBook;
    private int yearBook;

    public MenuBiblioteca(Library library) {
        this.library=library;
    }

    public String generateMenu(int optionValue){
        try {
            if (optionValue == 1) {
                library.showListBooks(library.listBooks);
                printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionSubMenu()));
                message = "Correct option";
            } else if (optionValue == 2) {
                message = "Quit";
            } else {
                message="Select a valid option";
                printMessageReceived(message);
            }
        }catch (NumberFormatException ex){
            System.out.println("\nSelect a valid option. Only numbers, please!");
        }
        return message;
    }

    public void printMenuOptions(){
        System.out.println("\nSelect number:");
        System.out.println("1. List Books");
        System.out.println("2. Quit");
        System.out.print("Option: ");
    }

    public String generateSubMenu(int optionValue){
            switch (optionValue) {
                case 1:
                    receivedParametersForBook();
                    messageReceived=library.checkoutBook(nameBook,yearBook,library.listBooks);
                    printMessageReceived(messageReceived);
                    message = "Correct option";
                    break;
                case 2:
                    receivedParametersForBook();
                    receivedBook=library.searchBookinLibrary(nameBook,yearBook,library.listBooks);
                    messageReceived=library.returnBook(receivedBook,library.listBooks);
                    printMessageReceived(messageReceived);
                    message = "Correct option";
                    break;
                case 3:
                    message = "Quit";
                    break;
                default:
                    message="Select a valid option";
                    printMessageReceived(message);
                    break;
            }
        return message;
    }

    public void printSubMenuOptions(){
        System.out.println("\nWhat do you want to do today?\n");
        System.out.println("1. Checkout Book");
        System.out.println("2. Return Book");
        System.out.println("3. Back");
        System.out.print("Select number: ");
    }

    private void printMessageReceived(String message){
        System.out.println("\n---------------------------\n"+
                message+"\n---------------------------\n");

    }

    public String receivedOptionSubMenu(){
        return new Scanner(System.in).nextLine();
    }

    private void receivedParametersForBook(){
        System.out.print("Name of Book: ");
        nameBook=new Scanner(System.in).nextLine();
        System.out.print("Year of the book: ");
        yearBook=Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
