package com.twu.utils.optionsMenu;

import com.twu.library.Library;
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
        String[] informationBookItem = informationItem.split("-");

        messageReceived = library.checkoutItem(informationBookItem[0], Integer.parseInt(informationBookItem[1]));

        printerReader.printMessageReceived(messageReceived);
        message = dictionary.MESSAGE_CORRECT;
        return message;
    }

}
