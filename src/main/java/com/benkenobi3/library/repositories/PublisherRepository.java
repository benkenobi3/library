package com.benkenobi3.library.repositories;

import com.benkenobi3.library.models.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    List<Publisher> findAllByNameContaining(String name);

}
