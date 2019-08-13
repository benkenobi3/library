package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByNameContaining(String name);

    List<Book> findAllByDescriptionOrGratitudeContaining(String string, String string2);

}
