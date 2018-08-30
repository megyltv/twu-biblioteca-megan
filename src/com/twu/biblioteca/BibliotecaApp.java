package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library=new Library();
        MenuBiblioteca menu= new MenuBiblioteca();
        int optionMenu;

        System.out.println(library.showWelcomeMessage()+"\n");
        menu.printMenuOptions();

        Scanner inValueN = new Scanner(System.in);
        optionMenu=Integer.parseInt(inValueN.nextLine());

        menu.generateMenu(optionMenu);
        library.createListOfBooks();



    }
}
