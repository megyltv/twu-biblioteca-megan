package com.twu.auxiliary;

import com.twu.biblioteca.Library;

import java.util.Scanner;

public class MenuBiblioteca {
    public String message="";
    public String messageReceived="";
    public Library library;

    public MenuBiblioteca() {
        library=new Library();
    }

    public String generateMenu(int optionValue){
        if(optionValue==1){
            do {
                library.showListBooks();
                printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionMenu()));
            }while(message!="Quit");
            message="Correct option";
        }else if(optionValue==2){
            message="Quit";
        }else{
            message="Select a valid option";
            System.out.println(message);
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
                    System.out.print("Name of Book: ");
                    messageReceived=library.checkoutBook(receivedOptionMenu());
                    printMessageReceived(messageReceived);
                    message = "Correct option";
                    break;
                case 2:
                    System.out.print("Name of Book: ");
                    messageReceived=library.returnBook(receivedOptionMenu());
                    printMessageReceived(messageReceived);
                    message = "Correct option";
                    break;
                case 3:
                    message = "Quit";
                    break;
                default:
                    message = "Select a valid option";
                    System.out.println(message);
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

    public void printMessageReceived(String message){
        System.out.println("\n------------------------\n"+message+"\n------------------------\n");

    }

    public String receivedOptionMenu(){
        return new Scanner(System.in).nextLine();
    }
}
