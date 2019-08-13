package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByNameContaining(String name);

}
