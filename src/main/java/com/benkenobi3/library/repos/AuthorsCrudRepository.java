package com.benkenobi3.library.repos;

import com.benkenobi3.library.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsCrudRepository extends CrudRepository<Author, Integer> {


}
