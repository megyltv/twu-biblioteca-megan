package com.twu.biblioteca;

public class MenuBiblioteca {
    public String message="";
    public int controllerMenu;

    public MenuBiblioteca() {
    }

    public String generateMenu(int optionValue){
        controllerMenu=1;

            switch (optionValue) {
                case 1:
                    message = "Correct option";
                    break;
                case 2:
                    controllerMenu=0;
                default:
                    message = "Select a valid option";
            }
        return message;
    }

    public void printMenuOptions(){
        System.out.println("Select an Option:");
        System.out.println("1. List Books");
        System.out.println("2. Quit");
    }


}
