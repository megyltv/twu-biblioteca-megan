package com.twu.utils;

import java.util.Scanner;

public class PrinterReader {

    public void printMenuOptions() {
        System.out.println("\nSelect number:");
        System.out.println("1. List Books");
        System.out.println("2. List Movies");
        System.out.println("3. User Information");
        System.out.println("4. Quit");
        System.out.print("Option: ");
    }

    public void printSubMenuOptions() {
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

    public String receivedParametersForBook() {
        String nameBook;
        int yearBook;

        System.out.print("Name of Book: ");
        nameBook = new Scanner(System.in).nextLine();
        System.out.print("Year of the book: ");
        yearBook = Integer.parseInt(new Scanner(System.in).nextLine());

        return nameBook+"-"+yearBook;

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
