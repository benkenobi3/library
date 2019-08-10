package com.benkenobi3.library.controllers;

import com.benkenobi3.library.exceptions.NotFoundException;
import com.benkenobi3.library.models.View;
import com.benkenobi3.library.models.entity.Book;
import com.benkenobi3.library.repositories.BookRepository;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    @JsonView(View.LIBRARY_VIEW.class)
    public List<Book> getBooks() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @GetMapping("{id}")
    @JsonView(View.BOOK_VIEW.class)
    public Book getBookById(@PathVariable Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        bookOptional.orElseThrow(NotFoundException::new);
        return bookOptional.get();
    }

    @PostMapping
    @JsonView(View.BOOK_VIEW.class)
    public Book createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @PostMapping("{id}")
    @JsonView(View.BOOK_VIEW.class)
    public String addAuthorById(@PathVariable Integer id, @RequestBody Book book) {
        return "nothing happens";
    }

    @PutMapping("{id}")
    @JsonView(View.BOOK_VIEW.class)
    public Book updBookById(@PathVariable Integer id, @RequestBody Book book) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        bookOptional.orElseThrow(NotFoundException::new);
        book.setId(bookOptional.get().getId());
        bookRepository.delete(bookOptional.get());
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("{id}")
    public void delBookById(@PathVariable Integer id) {
        Optional<Book> libOptional = bookRepository.findById(id);
        libOptional.orElseThrow(NotFoundException::new);
        bookRepository.delete(libOptional.get());
    }

    public BookRepository getBookRepository() {
        return bookRepository;
    }

}
