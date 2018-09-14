package com.twu.library.libraries;

import com.twu.library.ItemsRegistered;
import com.twu.library.libraries.ItemLibrary;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private Dictionary dictionary;
    private ItemLibrary itemLibrary;
    private Login login;
    public List<ItemsRegistered> itemsRegisteredList;
    private PrinterReader printerReader;

    public Library(){}

    public Library(ItemLibrary itemLibrary) {
        dictionary=new Dictionary();
        this.itemLibrary =itemLibrary;
        login=new Login();
        itemsRegisteredList=new ArrayList<ItemsRegistered>();
        printerReader=new PrinterReader();
    }

    public String showWelcomeMessage() {
        String welcomeMessage;
        welcomeMessage = dictionary.MESSAGE_WELCOME_TO_LIBRARY;
        return welcomeMessage;
    }

    public void showItemsRegistered(List<ItemsRegistered>itemsRegisteredList){
        printerReader.printItemsRegisteredTitles();
        for(ItemsRegistered itemsRegistered:itemsRegisteredList){
            printerReader.printItemsRegistered(itemsRegistered);
        }
    }

    public String showListItem(){

        return itemLibrary.showListItem();
    }

    public String checkoutItem(String nameItemCheckout) {
        String message=itemLibrary.checkoutItem(nameItemCheckout);

        if(message.equals(dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_OUT)){
            itemsRegisteredList.add(new ItemsRegistered(login.getCurrentUser(),nameItemCheckout));
            System.out.println(itemsRegisteredList.get(0).getNameItem());
        }

        return message;
    }

    public String checkinItem() {
        String message=itemLibrary.checkinItem();

        return message;
    }

    public Object searchItemInLibrary(String nameItem) {

        return itemLibrary.searchItem(nameItem);
    }

    public List<ItemsRegistered> getCurrentLisItemsRegistered(){
        System.out.println(itemsRegisteredList.get(0).getNameItem());
        return itemsRegisteredList;
    }


}
