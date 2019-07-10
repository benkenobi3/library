package com.benkenobi3.library.models;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String name;

    private List<Author> authors = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    private List<String> publishers;
    private String description;
    private String gratitudes;

    private int edition;
    private int volume;
    private int releaseYear;

    public Book() {}

    public Book (String name, List<Author> authors, List<Category> categories,
                 List<String> publishers,
                 String description, String gratitudes,
                 int edition, int volume, int releaseYear)
    {
        this.name = name;
        this.authors = authors;
        this.categories = categories;
        this.publishers = publishers;
        this.description = description;
        this.gratitudes = gratitudes;
        this.edition = edition;
        this.volume = volume;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<String> getPublishers() {
        return publishers;
    }

    public String getDescription() {
        return description;
    }

    public String getGratitudes() {
        return gratitudes;
    }

    public int getEdition() {
        return edition;
    }

    public int getVolume() {
        return volume;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}
