package com.twu.library;

public class Movie {
    private String nameMovie;
    private String directorMovie;
    private int yearMovie;
    private String ratingMovie;
    private boolean isAvailable;
    private String userIdWhenNotAvailable;

    public Movie() {
    }

    public Movie(String nameMovie, String directorMovie, int yearMovie, String ratingMovie) {
        this.nameMovie = nameMovie;
        this.directorMovie = directorMovie;
        this.yearMovie = yearMovie;
        this.ratingMovie = ratingMovie;
        this.userIdWhenNotAvailable="";
    }

    public Movie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String informationOfMovie(Movie movie){

        return nameMovie + " \t| " + directorMovie + " \t| " + yearMovie + "\t| "+ratingMovie;
    }

    public void setUserIdWhenNotAvailable(String userIdWhenNotAvailable) {
        this.userIdWhenNotAvailable = userIdWhenNotAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
