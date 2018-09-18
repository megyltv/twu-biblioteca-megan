package com.twu.utils.Menu.optionsSubMenu;

import com.twu.library.libraries.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

public class OptionOne implements Options {
    private Library library;
    private Dictionary dictionary;
    private PrinterReader printerReader;

    public OptionOne(Library library){
        this.library=library;
        printerReader=new PrinterReader();
        dictionary=new Dictionary();
    }

    @Override
    public String resolve(){
        String messageReceived="";
        String message="";
        String informationItem;

        informationItem = printerReader.receivedParametersForItem();

        messageReceived = library.checkoutItem(informationItem);

        printerReader.printMessageReceived(messageReceived);
        message = dictionary.MESSAGE_CORRECT;
        return message;
    }



}
