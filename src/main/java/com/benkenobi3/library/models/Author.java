package com.benkenobi3.library.models;

public class Author {

    private String name;
    private boolean isMain;

    public Author (String name, boolean isMain) {
        this.name = name;
        this.isMain = isMain;
    }

    public boolean isMain() {return isMain;}

    public String getName() {return name;}

}