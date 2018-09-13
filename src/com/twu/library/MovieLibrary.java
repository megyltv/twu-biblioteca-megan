package com.twu.library;

import com.twu.login.Login;
import com.twu.utils.Dictionary;
import com.twu.utils.PrinterReader;

import java.util.ArrayList;
import java.util.List;

public class MovieLibrary implements ItemLibrary{
    private List<Movie>listMovies;
    private PrinterReader printerReader;
    private Dictionary dictionary;

    public MovieLibrary(List<Movie>listMovies, Login login) {
        this.listMovies=listMovies;
    }

    @Override
    public String showListItem() {
        String detailsBook = "";

        printerReader.printTitles(dictionary.TITLE_LIST_BOOKS);
        System.out.printf("%-40s |%-30s |%-20s\n", dictionary.TITLE_NAME_BOOK, dictionary.TITLE_AUTHOR_BOOK, dictionary.TITLE_YEAR_PUBLICATION);
        for (Movie movie:listMovies) {
            if (movie.isAvailable()) {
                detailsBook = movie.informationOfMovie(movie);
            }
        }
        return detailsBook;
    }

    @Override
    public String checkoutItem(String nameItem, int yearItem) {
        return null;
    }

    @Override
    public String checkinItem() {
        return null;
    }

    @Override
    public Object searchItem(String nameItem, int yearItem) {
        return null;
    }
}
