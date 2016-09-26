package com.library.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import com.library.persistence.Author;

@Entity
@Table(name = "books")
@NamedQuery(name = "Book.findAll", query = "select b from Book b")
public class Book implements Serializable{

    @Id
    @Column(name = "idbooks")
    private Integer idbooks;

    @Column(name = "name")
    private String name;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "publish_year")
    private Integer publishYear;

    @Column(name = "genre")
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idauthors", referencedColumnName = "id")
    private Author author;

    public Book() {
    }

    public Book(Integer idbooks, String name, Integer pageCount,
                Integer publishYear,
                String genre) {
        this.idbooks = idbooks;
        this.name = name;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
        this.genre = genre;
    }

    public Integer getIdbooks() {
        return idbooks;
    }

    public void setIdbooks(Integer idbooks) {
        this.idbooks = idbooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
