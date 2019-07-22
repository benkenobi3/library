package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
