package com.twu.utils.optionsMenu;

import com.twu.library.Library;
import com.twu.utils.Dictionary;
import com.twu.utils.MenuLibrary;


public class OptionTwo implements Options {
    Library library;
    MenuLibrary menuLibrary;
    Dictionary dictionary;

    public OptionTwo(Library library){
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

        library.searchBookinLibrary(dataBook[0], Integer.parseInt(dataBook[1]));
        messageReceived = library.returnBook();
        menuLibrary.printMessageReceived(messageReceived);
        message = dictionary.messageCorrect;
        return message;
    }
}
