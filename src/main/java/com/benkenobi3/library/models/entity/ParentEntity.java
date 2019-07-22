package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@MappedSuperclass
public abstract class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.ID_VIEW.class)
    private int id;

    @JsonView(View.BOOK_VIEW.class)
    private String name;

    public void setId(int id) {
        id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
