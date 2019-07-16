package com.benkenobi3.library.repos;

import com.benkenobi3.library.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BooksCrudRepository extends CrudRepository<Book, Integer> {


}
