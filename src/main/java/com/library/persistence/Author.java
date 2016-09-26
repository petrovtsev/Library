package com.library.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.*;

import static java.util.logging.Level.ALL;


@Entity
@Table(name = "authors")
@NamedQuery(name = "Author.findAll", query = "select a from Author a")
public class Author {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    public Author(Integer id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Author() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
