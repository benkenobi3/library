package com.benkenobi3.library.models;

import javax.persistence.*;

@Entity
public abstract class MEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int Id;

    @Basic
    @Column(name = "NAME")
    private String name;

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
