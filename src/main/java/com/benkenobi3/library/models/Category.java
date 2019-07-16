package com.benkenobi3.library.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "CATEGORIES")
public class Category extends MEntity {

    @ManyToMany
    @JoinTable(name = "category_book",
            joinColumns = @JoinColumn(name="category_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName="id")
    )
    private Set<Book> books;

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

}
