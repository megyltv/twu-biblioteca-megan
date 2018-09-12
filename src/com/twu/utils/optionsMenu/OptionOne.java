package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;

public class OptionOne implements Options {
    Library library;
    MenuLibrary menuLibrary;
    Dictionary dictionary;

    public OptionOne(Library library){
        this.library=library;
        menuLibrary=new MenuLibrary();
    }

    @Override
    public String resolve(){
        String messageReceived="";
        String message="";
        String informationBook;

        informationBook = menuLibrary.receivedParametersForBook();
        String[] dataBook = informationBook.split("-");

        messageReceived = library.checkoutBook(dataBook[0], Integer.parseInt(dataBook[1]));

        menuLibrary.printMessageReceived(messageReceived);
        message = dictionary.messageCorrect;
        return message;
    }

}
