package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByNameContaining(String name);

}
