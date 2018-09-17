package com.twu.library.libraries;

import com.twu.library.Items;
import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private Dictionary dictionary;
    private ItemLibrary itemLibrary;
    private Login login;
    public List<Items> itemsRegisteredList;
    private boolean status=true;
    private boolean statusListEmpty=true;
    private PrinterReader printerReader;

    public Library(){}

    public Library(ItemLibrary itemLibrary,Login login) {
        this.printerReader=new PrinterReader();
        dictionary=new Dictionary();
        this.itemLibrary =itemLibrary;
        this.login=login;

    }

    public String showWelcomeMessage() {
        String welcomeMessage;
        welcomeMessage = dictionary.MESSAGE_WELCOME_TO_LIBRARY;
        return welcomeMessage;
    }

    public void showListOfItemsRegistered(List<Items>itemsRegisteredList,String itemType){
        printerReader.printMessageReceived(itemType);
        printerReader.printItemsRegisteredTitles();
        for(Items item:itemsRegisteredList){
            printerReader.printItemsRegistered(item);
        }

    }

    public String showListItem(){

        return itemLibrary.showListItem();
    }

    public String checkoutItem(String nameItemCheckout) {
        String message=itemLibrary.checkoutItem(nameItemCheckout);

        addItemToListRegistered(message,nameItemCheckout);

        return message;
    }

    private void addItemToListRegistered(String message,String nameItemCheckout){
        if(this.status){
            itemsRegisteredList=new ArrayList<Items>();
            status=false;
        }

        if(message.equals(dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_OUT)){
            itemsRegisteredList.add(new Items(login.getCurrentUser(),nameItemCheckout));
            statusListEmpty=false;
        }
    }

    public String checkinItem() {
        String message=itemLibrary.checkinItem();

        return message;
    }

    public Object searchIteminLibrary(String nameItem) {

        return itemLibrary.searchItem(nameItem);
    }

    public List<Items> getCurrentList(){
        if(statusListEmpty){
            return Collections.emptyList();
        }

        return this.itemsRegisteredList;
    }
}
