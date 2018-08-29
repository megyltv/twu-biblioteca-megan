package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    public String nameLibrary;
    protected String welcomeMessage;


    public Library() {
        welcomeMessage="Welcome to the Library";
    }

    public String showWelcomeMessage(){
        return welcomeMessage;
    }
}
