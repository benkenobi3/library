package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    /*@Modifying
    @Transactional
    @Query(value = "insert into LIBRARY_BOOK (library_id, book_id) values (:library_id, :book_id)",
            nativeQuery = true)
    void insertBook(@Param("library_id") Integer library_id, @Param("book_id") Integer book_id);*/

}
