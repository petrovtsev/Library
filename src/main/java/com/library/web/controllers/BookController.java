package com.library.web.controllers;

import com.library.persistence.Book;
import com.library.web.model.BookModel;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class BookController {

    @EJB
    private BookModel bookModel;

    private List<Book> list;


    public BookController(){
    }

    @PostConstruct
    public void init(){
        list=bookModel.returnAllBooks();
    }

    public List<Book> getList(){
        return list;
    }

    public void setList(List<Book> list){
        this.list = list;
    }
}