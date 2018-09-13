package com.twu.library;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    Movie movie;

    @Before
    public void setUp() throws Exception {
      movie=new Movie("Harry Potter","Chris Columbus",2001,"10");
    }

    @Test
    public void shouldReturnDetailsOfMoviesWhenItIsAsked(){
        String informationOfMovie="Harry Potter \t| Chris Columbus \t| 2001\t| 10";

        assertEquals(informationOfMovie,movie.informationOfMovie(movie));
    }

}