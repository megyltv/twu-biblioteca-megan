package com.twu.library;

import com.twu.login.Login;
import com.twu.utils.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class Library {

    public List<Movie> listMovies;
    private Book findBook;
    private Dictionary dictionary;
    private Login login;
    private  ItemLibrary itemLibrary;

    public Library(){}

    public Library(ItemLibrary itemLibrary) {
        dictionary=new Dictionary();
        login=new Login();
        this.itemLibrary =itemLibrary;
    }

    public String showWelcomeMessage() {
        String welcomeMessage;
        welcomeMessage = dictionary.MESSAGE_WELCOME_TO_LIBRARY;
        return welcomeMessage;
    }

    public String showListItem(){

        return itemLibrary.showListItem();
    }

    public String checkoutItem(String nameItemCheckout) {

        return itemLibrary.checkoutItem(nameItemCheckout);
    }

    public String checkinItem() {

        return itemLibrary.checkinItem();
    }

    public Object searchIteminLibrary(String nameItem) {

        return itemLibrary.searchItem(nameItem);
    }

}
