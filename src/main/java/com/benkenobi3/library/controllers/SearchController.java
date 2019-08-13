package com.benkenobi3.library.controllers;

import com.benkenobi3.library.models.View;
import com.benkenobi3.library.models.entity.Author;
import com.benkenobi3.library.models.entity.Book;
import com.benkenobi3.library.models.entity.Category;
import com.benkenobi3.library.models.entity.Publisher;
import com.benkenobi3.library.repositories.AuthorRepository;
import com.benkenobi3.library.repositories.BookRepository;
import com.benkenobi3.library.repositories.CategoryRepository;
import com.benkenobi3.library.repositories.PublisherRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping("book")
    @JsonView(View.BOOK_VIEW.class)
    public List<Book> findBook(@RequestBody String string)
    {
        List<Book> res = bookRepository.findAllByNameContaining(string);
        res.addAll(bookRepository.findAllByDescriptionOrGratitudeContaining(string, string));
        return res;
    }

    @PostMapping("author")
    @JsonView(View.AUTHOR_VIEW.class)
    public List<Author> findAuthor(@RequestBody String string)
    {
        return authorRepository.findAllByNameContaining(string);
    }

    @PostMapping("publisher")
    @JsonView(View.PUBLISHER_VIEW.class)
    public List<Publisher> findPublisher(@RequestBody String string)
    {
        return publisherRepository.findAllByNameContaining(string);
    }

    @PostMapping("category")
    @JsonView(View.CATEGORY_VIEW.class)
    public List<Category> findCategory(@RequestBody String string)
    {
        return categoryRepository.findAllByNameContaining(string);
    }

}