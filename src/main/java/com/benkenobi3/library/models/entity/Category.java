package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Category extends ParentEntity {

    @JsonView(View.CATEGORY_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    private Set<Book> books;

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
