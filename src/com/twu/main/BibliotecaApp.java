package com.twu.main;

import com.twu.utils.MenuBiblioteca;
import com.twu.biblioteca.Library;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library=new Library();
        MenuBiblioteca menu= new MenuBiblioteca(library);
        int optionMenu;
        String message="";

        do {
            System.out.println("\n"+library.showWelcomeMessage()+"\n");
            try {
                menu.printMenuOptions();
                optionMenu = Integer.parseInt(new Scanner(System.in).nextLine());
                message=menu.generateMenu(optionMenu);
            }catch (NumberFormatException ex){
                System.out.println("Select a valid option. Only numbers!");
            }

        }while(message!="Quit");

    }
}