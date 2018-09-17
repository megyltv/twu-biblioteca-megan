package com.twu.library;

import com.twu.utils.PrinterReader;

public class Movie {
    private String nameMovie;
    private String directorMovie;
    private int yearMovie;
    private String ratingMovie;
    private boolean isAvailable;
    private PrinterReader printerReader;

    public Movie() {
    }


    public Movie(String nameMovie, String directorMovie, int yearMovie, String ratingMovie) {
        this.nameMovie = nameMovie;
        this.directorMovie = directorMovie;
        this.yearMovie = yearMovie;
        this.ratingMovie = ratingMovie;
        this.isAvailable=true;
        printerReader= new PrinterReader();
    }

    public Movie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String informationOfMovie(Movie movie){
        printInformationOfMovie(movie);
        return nameMovie + " \t| " + directorMovie + " \t| " + yearMovie + " \t| "+ratingMovie;
    }

    public void printInformationOfMovie(Movie newMovie) {
        printerReader.printInformationOfMovies(newMovie);
    }

    public boolean changeStatus(){
        return !isAvailable;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDirectorMovie() {
        return directorMovie;
    }

    public int getYearMovie() {
        return yearMovie;
    }

    public String getRatingMovie() {
        return ratingMovie;
    }
}
