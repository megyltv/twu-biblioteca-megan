package com.twu.library;

public class Movie {
    private String nameMovie;
    private String directorMovie;
    private int yearMovie;
    private String ratingMovie;
    private boolean isAvailable;

    public Movie() {
    }

    public Movie(String nameMovie, String directorMovie, int yearMovie, String ratingMovie) {
        this.nameMovie = nameMovie;
        this.directorMovie = directorMovie;
        this.yearMovie = yearMovie;
        this.ratingMovie = ratingMovie;
    }

    public Movie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
}
