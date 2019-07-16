package com.benkenobi3.library.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

@Entity
@DynamicUpdate
@Table(name = "BOOKS")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int Id;

    @Basic
    @Column(name = "NAME")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Category> categories;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Publisher> publishers;

    @Basic
    @Column(name = "DESCRIPTION")
    private String description;

    @Basic
    @Column(name = "GRATITUDE")
    private String gratitude;

    @Basic
    @Column(name = "EDITION")
    private int edition;

    @Basic
    @Column(name = "VOLUME")
    private int volume;

    @Basic
    @Column(name = "RELEASE_YEAR")
    private int releaseYear;

    public int getId() {
        return Id;
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

    public void setId(int Id) {
        this.Id = Id;
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


}
