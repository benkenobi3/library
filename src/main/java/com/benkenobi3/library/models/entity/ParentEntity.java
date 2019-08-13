package com.benkenobi3.library.models.entity;

import com.benkenobi3.library.models.View;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Objects;

@MappedSuperclass
public abstract class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(View.ID_VIEW.class)
    private int id;

    @JsonView(View.LIBRARY_VIEW.class)
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

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParentEntity that = (ParentEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
