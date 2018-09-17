package com.twu.library.libraries;

import com.twu.library.Items;
import com.twu.login.Login;
import com.twu.utils.Dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private Dictionary dictionary;
    private ItemLibrary itemLibrary;
    private Login login;
    public List<Items> itemsRegisteredList;
    boolean status=true;
    boolean statusListEmpty=true;

    public Library(){}

    public Library(ItemLibrary itemLibrary,Login login) {
        dictionary=new Dictionary();
        this.itemLibrary =itemLibrary;
        this.login=login;

    }

    public String showWelcomeMessage() {
        String welcomeMessage;
        welcomeMessage = dictionary.MESSAGE_WELCOME_TO_LIBRARY;
        return welcomeMessage;
    }

    public void showListOfItemsRegistered(List<Items>itemsRegisteredList){
        for(Items item:itemsRegisteredList){
            System.out.println(item.getUser().getIdLibraryCode()+item.getNameItem());
        }

    }

    public String showListItem(){

        return itemLibrary.showListItem();
    }

    public String checkoutItem(String nameItemCheckout) {
        String message=itemLibrary.checkoutItem(nameItemCheckout);

        if(this.status==true){
            itemsRegisteredList=new ArrayList<Items>();
            status=false;
        }

        if(message.equals(dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_OUT)){
            System.out.println(login.getCurrentUser().getIdLibraryCode());
            itemsRegisteredList.add(new Items(login.getCurrentUser(),nameItemCheckout));
            statusListEmpty=false;
        }

        return message;
    }

    public String checkinItem() {
        String message=itemLibrary.checkinItem();

        return message;
    }

    public Object searchIteminLibrary(String nameItem) {

        return itemLibrary.searchItem(nameItem);
    }

    public List<Items> getCurrentList(){
        if(statusListEmpty==true){
            return Collections.emptyList();
        }

        return this.itemsRegisteredList;
    }
}
