package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;


public class OptionTwo implements Options {
    private Library library;
    private Dictionary dictionary;
    private PrinterReader printerReader;


    public OptionTwo(Library library){
        this.library=library;
        printerReader=new PrinterReader();
        dictionary=new Dictionary();
    }

    @Override
    public String resolve(){
        String messageReceived="";
        String message="";
        String informationBook;

        informationBook = printerReader.receivedParametersForItem();
        String[] informationBookSeparate = informationBook.split("-");

        library.searchIteminLibrary(informationBookSeparate[0], Integer.parseInt(informationBookSeparate[1]));
        messageReceived = library.checkinItem();
        printerReader.printMessageReceived(messageReceived);
        message = dictionary.MESSAGE_CORRECT;
        return message;
    }
}
