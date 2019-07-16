package com.benkenobi3.library.controllers;

import com.benkenobi3.library.exceptions.NotFoundException;
import com.benkenobi3.library.models.Book;
import com.benkenobi3.library.models.Library;
import com.benkenobi3.library.repos.BooksCrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("library")
public class LibraryController {

    private BooksCrudRepository booksCrudRepository;

    private int counter = 0;

    private Map<String, Library> libraries = new HashMap<>();

    @GetMapping
    public Map<String, Library> getLibs() {return libraries;}

    @GetMapping("{id}")
    public Library getLibById(@PathVariable String id) {
        if (libraries.containsKey(id))
            return libraries.get(id);
        throw new NotFoundException();
    }

    @PostMapping
    public Library createLib(@RequestBody String name) {
        libraries.put(Integer.toString(counter), new Library(name));
        counter++;
        return libraries.get(Integer.toString(counter-1));
    }

    @PostMapping("{id}")
    public Book addBook(@PathVariable String id, @RequestBody String bookId){

        Library library = getLibById(id);

        Optional<Book> bookOptional = booksCrudRepository.findById(Integer.parseInt(bookId));

        if (bookOptional.isPresent()) {
            library.add(bookOptional.get());
            return bookOptional.get();
        }
        else
            throw new NotFoundException();

    }

    @PutMapping("{id}")
    public Library updateLibById(@PathVariable String id, @RequestBody String name) {
        Library library = getLibById(id);
        library.setName(name);
        return library;
    }

    @DeleteMapping("{id}")
    public void deleteLibById(@PathVariable String id) {
        if (libraries.containsKey(id))
            libraries.remove(id);
        else
            throw new NotFoundException();
    }

}
