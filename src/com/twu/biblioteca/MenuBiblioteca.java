package com.twu.biblioteca;

public class MenuBiblioteca {
    String message="";

    public MenuBiblioteca() {
    }

    public String generateMenu(int optionValue){
        switch (optionValue){
            case 1:
                message="Correct option";
        }

        return message;
    }


}
