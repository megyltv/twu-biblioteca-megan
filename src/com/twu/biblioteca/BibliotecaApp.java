package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library;

        ArrayList<Book> listBooks=new ArrayList<Book>();

        listBooks.add(new Book("Test Driven Development: By Example","Kent Beck",2002));
        //listBooks.add(new Book());
        //listBooks.add(new Book());
        //listBooks.add(new Book());

        library = new Library(listBooks);
        library.createListOfBooks();


    }
}
