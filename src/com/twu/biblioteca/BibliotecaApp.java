package com.twu.biblioteca;

import com.twu.auxiliary.MenuBiblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library=new Library();
        MenuBiblioteca menu= new MenuBiblioteca();
        int optionMenu;
        String message="";

        do {
            System.out.println("\n"+library.showWelcomeMessage()+"\n");
            try {
                menu.printMenuOptions();
                Scanner inValueN = new Scanner(System.in);
                optionMenu = Integer.parseInt(inValueN.nextLine());
                message=menu.generateMenu(optionMenu);
            }catch (NumberFormatException ex){
                System.out.println("Select a valid option. Only numbers!");
            }

        }while(message!="Quit");

    }
}
