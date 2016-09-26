package com.library.web.model;

import com.library.persistence.Book;
import com.library.services.BookService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class BookModel {

    private BookService bookService;

    public BookService getBookService() {
        return bookService;
    }

    @EJB
    public void setBookService(BookService bookService){
        this.bookService = bookService;
        }


    public List<Book> returnAllBooks(){
        return getBookService().returnAllBook();
    }
}
