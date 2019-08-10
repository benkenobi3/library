package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.LIBRARY_VIEW.class)
    private int id;

    @JsonView(View.LIBRARY_VIEW.class)
    private String name;

    @JsonView(View.LIBRARY_VIEW.class)
    private String description;

    @JsonView(View.LIBRARY_VIEW.class)
    private String gratitude;

    @JsonView(View.LIBRARY_VIEW.class)
    private int edition;

    @JsonView(View.LIBRARY_VIEW.class)
    private int volume;

    @JsonView(View.LIBRARY_VIEW.class)
    private int releaseYear;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    @JsonView(View.IGNORE.class)
    private Set<Library> library;

    @JsonView(View.BOOK_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name="book_id_a", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="author_id", referencedColumnName="id")
    )
    private Set<Author> authors;

    @JsonView(View.BOOK_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_category",
            joinColumns = @JoinColumn(name="book_id_c", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="category_id", referencedColumnName="id")
    )
    private Set<Category> categories;

    @JsonView(View.BOOK_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book_publisher",
            joinColumns = @JoinColumn(name="book_id_p", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="publisher_id", referencedColumnName="id")
    )
    private Set<Publisher> publishers;

    public Book() {
        name = "";
        description = "";
        gratitude = "";
        volume = 0;
        releaseYear = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public String getDescription() {
        return description;
    }

    public String getGratitude() {
        return gratitude;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGratitude(String gratitude) {
        this.gratitude = gratitude;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Set<Library> getLibrary() {
        return library;
    }

    public void setLibrary(Set<Library> library) {
        this.library = library;
    }

    public void addLibrary(Library lib)
    {
        library.add(lib);
    }

}
