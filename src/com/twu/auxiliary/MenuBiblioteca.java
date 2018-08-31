package com.twu.auxiliary;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.util.Scanner;

public class MenuBiblioteca {
    protected String message="";
    protected Library library;
    protected String messageReceived="";
    protected Book receivedBook;

    private String nameBook;
    private int yearBook;

    public MenuBiblioteca() {
        library=new Library();
    }

    public String generateMenu(int optionValue){
        try {
            if (optionValue == 1) {
                library.showListBooks();
                printSubMenuOptions();
                generateSubMenu(Integer.parseInt(receivedOptionMenu()));
                message = "Correct option";
            } else if (optionValue == 2) {
                message = "Quit";
            } else {
                message = "Select a valid option";
                System.out.println(message);
            }
        }catch (NumberFormatException ex){
            System.out.println("\nSelect a valid option. Only numbers!");
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
                    receivedParametersForMethod();
                    messageReceived=library.checkoutBook(nameBook,yearBook);
                    printMessageReceived(messageReceived);
                    message = "Correct option";
                    break;
                case 2:
                    receivedParametersForMethod();
                    receivedBook=library.searchBookinLibrary(nameBook,yearBook);
                    messageReceived=library.returnBook(receivedBook);
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
        String scan=new Scanner(System.in).nextLine();
        return scan;
    }

    public void receivedParametersForMethod(){
        System.out.print("Name of Book: ");
        nameBook=new Scanner(System.in).nextLine();
        System.out.print("Year of the book: ");
        yearBook=Integer.parseInt(new Scanner(System.in).nextLine());
    }
}
