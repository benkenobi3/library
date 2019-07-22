package com.benkenobi3.library.controllers;

import com.benkenobi3.library.exceptions.NotFoundException;
import com.benkenobi3.library.models.View;
import com.benkenobi3.library.models.entity.Book;
import com.benkenobi3.library.models.entity.Library;
import com.benkenobi3.library.repositories.BookRepository;
import com.benkenobi3.library.repositories.LibraryRepository;
import com.fasterxml.jackson.annotation.JsonView;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    @JsonView(View.LIBRARY_VIEW.class)
    public List<Library> getLibraries() {
        return Lists.newArrayList(libraryRepository.findAll());
    }

    @GetMapping("{id}")
    @JsonView(View.BOOK_VIEW.class)
    public Library getLibById(@PathVariable Integer id) {
        Optional<Library> libOptional = libraryRepository.findById(id);
        libOptional.orElseThrow(NotFoundException::new);
        return libOptional.get();
    }

    @PostMapping
    @JsonView(View.LIBRARY_VIEW.class)
    public Library createLib(@RequestBody String name) {
        Library library = new Library();
        library.setName(name);
        libraryRepository.save(library);
        return library;
    }

    @PostMapping("{id}")
    @JsonView(View.BOOK_VIEW.class)
    public Library addBookById(@PathVariable Integer id, @RequestBody Integer book_id)
    {
        Optional<Library> libOptional = libraryRepository.findById(id);
        libOptional.orElseThrow(NotFoundException::new);
        Optional<Book> bookOptional = bookRepository.findById(book_id);
        bookOptional.orElseThrow(NotFoundException::new);
        libraryRepository.insertBook(id, book_id);
        return libOptional.get();
    }

    @PutMapping("{id}")
    @JsonView(View.LIBRARY_VIEW.class)
    public Library updLibById(@PathVariable Integer id, @RequestBody String name) {
        Optional<Library> libOptional = libraryRepository.findById(id);
        libOptional.orElseThrow(NotFoundException::new);
        libOptional.get().setName(name);
        libraryRepository.save(libOptional.get());
        return libOptional.get();
    }

    @DeleteMapping("{id}")
    public void delLibById(@PathVariable Integer id) {
        Optional<Library> libOptional = libraryRepository.findById(id);
        libOptional.orElseThrow(NotFoundException::new);
        libraryRepository.delete(libOptional.get());
    }

}
