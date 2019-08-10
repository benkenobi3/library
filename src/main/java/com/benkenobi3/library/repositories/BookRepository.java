package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
