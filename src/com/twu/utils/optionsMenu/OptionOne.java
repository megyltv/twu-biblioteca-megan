package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;
import com.twu.utils.PrinterReader;

public class OptionOne implements Options {
    private Library library;
    private MenuLibrary menuLibrary;
    private Dictionary dictionary;
    private PrinterReader printerReader;

    public OptionOne(Library library){
        this.library=library;
        menuLibrary=new MenuLibrary();
        printerReader=new PrinterReader();
        dictionary=new Dictionary();
    }

    @Override
    public String resolve(){
        String messageReceived="";
        String message="";
        String informationBook;

        informationBook = printerReader.receivedParametersForBook();
        String[] dataBook = informationBook.split("-");

        messageReceived = library.checkoutBook(dataBook[0], Integer.parseInt(dataBook[1]));

        printerReader.printMessageReceived(messageReceived);
        message = dictionary.messageCorrect;
        return message;
    }

}
