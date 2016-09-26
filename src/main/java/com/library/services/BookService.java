package com.library.services;

import com.library.persistence.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookService {

    @PersistenceContext(unitName ="persistence")
    private EntityManager em;



    public List<Book> returnAllBook(){
        List<Book> resultList = em
                .createNamedQuery("Book.findAll", Book.class)
                 .getResultList();
        return resultList;
    }


}

