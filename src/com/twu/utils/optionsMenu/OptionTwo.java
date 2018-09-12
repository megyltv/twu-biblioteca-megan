package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;
import com.twu.utils.PrinterReader;


public class OptionTwo implements Options {
    private Library library;
    private MenuLibrary menuLibrary;
    private Dictionary dictionary;
    private PrinterReader printerReader;

    public OptionTwo(Library library){
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
        String[] informationBookSeparate = informationBook.split("-");

        library.searchBookinLibrary(informationBookSeparate[0], Integer.parseInt(informationBookSeparate[1]));
        messageReceived = library.returnBook();
        printerReader.printMessageReceived(messageReceived);
        message = dictionary.messageCorrect;
        return message;
    }
}
