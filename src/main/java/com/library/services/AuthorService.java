package com.library.services;

import com.library.persistence.Author;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.*;
import java.util.List;

@Stateless
public class AuthorService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;


    public List<Author> returnAllAuthors(){
        List<Author> resultList = em.createNamedQuery("Author.findAll", Author.class)
            .getResultList();
        return resultList;
    }

    public void addAuthor(Author a){
        em.persist(a);
    }

    public void delAuthor(Integer id){
        Author author = em.find(Author.class, id);
        em.remove(author);
    }

    public Author getAuthor(Integer id){
        return em.find(Author.class, id);
    }

    public void updAuthor(Author a){
        em.merge(a);
    }

}

