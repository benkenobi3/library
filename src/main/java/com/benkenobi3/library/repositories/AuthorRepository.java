package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
