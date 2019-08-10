package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.LIBRARY_VIEW.class)
    private int id;

    @JsonView(View.LIBRARY_VIEW.class)
    private String name;

    @JsonView(View.LIBRARY_VIEW.class)
    private int booksCount;

    @JsonView(View.BOOK_VIEW.class)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "library_book",
            joinColumns = @JoinColumn(name="library_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName="id")
    )
    private Set<Book> books;

    public Library() {
        booksCount = 0;
        name = "";
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Set<Book> getBooks() {return books;}

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public int getBooksCount() {return booksCount;}

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }

}
