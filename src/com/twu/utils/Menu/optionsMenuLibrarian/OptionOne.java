package com.twu.utils.Menu.optionsMenuLibrarian;

import com.twu.library.Items;
import com.twu.library.libraries.Library;
import com.twu.utils.Dictionary;

import java.util.ArrayList;
import java.util.List;


public class OptionOne implements IOptionsLibrarian {
    private Library libraryBooks;
    private Library libraryMovies;
    private String message="";
    private Dictionary dictionary;
    private List<Items> itemsRegisteredList;

    public OptionOne(Library libraryBooks,Library libraryMovies){
        this.libraryBooks=libraryBooks;
        this.libraryMovies=libraryMovies;
        itemsRegisteredList = new ArrayList<Items>();
    }

    @Override
    public String resolve() {
        try {
            showListsOfItemsRegistered();
            message = dictionary.MESSAGE_CORRECT;
        } catch (NullPointerException e) {
            System.out.println("No items registered");
            message = dictionary.MESSAGE_CORRECT;
        }
        return message;

    }

    private void showListsOfItemsRegistered() {

        if (!libraryBooks.getCurrentList().isEmpty()) {
            itemsRegisteredList = libraryBooks.getCurrentList();
            libraryBooks.showListOfItemsRegistered(itemsRegisteredList,dictionary.TITLE_BOOKS);

        }
        if (!libraryMovies.getCurrentList().isEmpty()) {
            itemsRegisteredList = libraryMovies.getCurrentList();
            libraryMovies.showListOfItemsRegistered(itemsRegisteredList,dictionary.TITLE_MOVIES);
        }

    }
}
