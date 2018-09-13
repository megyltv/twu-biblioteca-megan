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
    private Movie findMovie;

    public MovieLibrary(List<Movie>listMovies, Login login) {
        this.listMovies=listMovies;
        printerReader=new PrinterReader();
    }

    @Override
    public String showListItem() {
        String detailsMovie = "";

        printerReader.printTitles(dictionary.TITLE_LIST_MOVIES);
        System.out.printf("%-20s |%-20s |%-10s |%-20s\n", dictionary.TITLE_NAME_MOVIE, dictionary.TITLE_DIRECTOR_MOVIE, dictionary.TITLE_YEAR_MOVIE,dictionary.TITLE_RATING_MOVIE);
        for (Movie movie:listMovies) {
            if (movie.isAvailable()) {
                detailsMovie = movie.informationOfMovie(movie);
            }
        }
        return detailsMovie;
    }

    @Override
    public String checkoutItem(String nameItem, int yearItem) {
        String message=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_OUT;

        for(Movie movieLooking: listMovies){
            if(nameItem.equals(movieLooking.getNameMovie())&&movieLooking.isAvailable()){
                movieLooking.setAvailable(movieLooking.changeStatus());
                message=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;
            }
        }

        return message;
    }



    @Override
    public String checkinItem() {
        String message=dictionary.MESSAGE_UNSUCCESSFUL_ITEM_CHECK_IN;

        for (Movie movieLooking:listMovies){
            if(movieLooking.getNameMovie().equals(findMovie.getNameMovie())){
                movieLooking.setAvailable(movieLooking.changeStatus());
                message=dictionary.MESSAGE_SUCCESSFUL_ITEM_CHECK_IN;
            }

        }

        return message;
    }

    @Override
    public Object searchItem(String nameItem, int yearItem) {
        findMovie= new Movie(nameItem);
        for(Movie movie:listMovies){
            if(movie.getNameMovie().equals(nameItem)){
                findMovie=movie;
            }
        }

        return findMovie;
    }
}
