package com.twu.utils;

import com.twu.library.Items;

import java.util.Scanner;

public class PrinterReader {
    private Dictionary dictionary;

    public void printMenuOptionsCustomer() {
        System.out.println("\nSelect number:");
        System.out.println("1. List Books");
        System.out.println("2. List Movies");
        System.out.println("3. User Information");
        System.out.println("4. Log Out");
        System.out.print("Option: ");
    }

    public void printMenuOptionsLibrarian(){
        System.out.println("\nSelect number:");
        System.out.println("1. Items Checked Out");
        System.out.println("2. Log Out");
        System.out.print("Option: ");
    }

    public void printSubMenuOptions(String typeItem) {
        System.out.println("\nWhat do you want to do today?\n");
        System.out.println("1. Checkout "+typeItem);
        System.out.println("2. Return "+typeItem);
        System.out.println("3. Back");
        System.out.print("Select number: ");
    }

    public void printMessageReceived(String message) {
        System.out.println("\n---------------------------\n" +
                message + "\n---------------------------\n");

    }

    public void printItemsRegisteredTitles(){
        System.out.printf("%-20s |%-20s |%-20s\n", dictionary.TITLE_ID_USER,dictionary.TITLE_NAME_USER, dictionary.TITLE_ITEM);
    }

    public void printItemsRegistered(Items itemsRegistered){
        System.out.printf("%-20s |%-20s |%-20s\n", itemsRegistered.getUser().getIdLibraryCode(), itemsRegistered.getUser().getNameUser(), itemsRegistered.getNameItem());
    }

    public String receivedOptionForMenuOrSubMenu(){
        return new Scanner(System.in).nextLine();
    }

    public String receivedParametersForItem() {
        String nameBook;

        System.out.print("Name of Item: ");
        nameBook = new Scanner(System.in).nextLine();

        return nameBook;

    }

    public String receivedParametersForLogin(){
        String idCodeUser;
        String password;

        System.out.print("ID User Code: ");
        idCodeUser=new Scanner(System.in).nextLine();
        System.out.print("Password: ");
        password=new Scanner(System.in).nextLine();

        return idCodeUser+"/"+password;
    }

    public void printTitles(String title){
        System.out.println("\n"+title+"\n");
    }
}
