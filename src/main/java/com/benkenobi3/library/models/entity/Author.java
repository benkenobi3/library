package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Author extends ParentEntity {

    public Author() {}

    @JsonView(View.AUTHOR_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
    private Set<Book> books;

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}