package com.benkenobi3.library.models;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private int counter = 0;

    private String name;

    private List<Book> books;

    public Library(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
        counter++;
    }

    public int getCount() {return counter;}
    public String getName() {return name;}
    public List<Book> getBooks() {return books;}

    public void setName(String name) {
        this.name = name;
    }

}
