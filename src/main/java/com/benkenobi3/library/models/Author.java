package com.benkenobi3.library.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "AUTHORS")
public class Author extends MEntity {

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name="author_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName="id")
    )
    private Set<Book> books;

    public Set<Book> getBooks() { return books; }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Basic
    @Column(name = "LASTNAME")
    private String lastname;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

}