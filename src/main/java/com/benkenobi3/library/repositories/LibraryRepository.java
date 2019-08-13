package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

    List<Library> findAllByNameContaining(String name);

}
