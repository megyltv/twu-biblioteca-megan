package com.twu.biblioteca;

import java.util.Scanner;

public class MenuBiblioteca {
    public String message="";
    public int controllerMenu;
    public Library library;

    public MenuBiblioteca() {
    }

    public String generateMenu(int optionValue){
        library=new Library();
            switch (optionValue) {
                case 1:
                    library.createListOfBooks();
                    library.showListBooks();
                    printSubMenuOptions();
                    generateSubMenu(Integer.parseInt(new Scanner(System.in).nextLine()));
                    message = "Correct option";
                    break;
                case 2:
                    message="Quit";
                default:
                    message = "Select a valid option";
            }
        return message;
    }

    public void printMenuOptions(){
        System.out.println("Select an Option:");
        System.out.println("1. List Books");
        System.out.println("2. Quit");
        System.out.print("Option: ");
    }

    public void printSubMenuOptions(){
        System.out.println("\nWhat do you want to do today?\n");
        System.out.println("1. Checkout Book");
        System.out.println("2. Return Book");
        System.out.println("3. Quit");
        System.out.print("Option: ");
    }

    public String generateSubMenu(int optionValue){
        switch (optionValue) {
            case 1:
                message = "1";
                break;
            case 2:
                message="2";
            case 3:
                message="Quit";
            default:
                message = "Select a valid option";
        }
        return message;
    }


}
