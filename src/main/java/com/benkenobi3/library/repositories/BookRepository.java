package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
