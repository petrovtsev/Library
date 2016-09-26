package com.library.web.model;

import com.library.persistence.Author;
import com.library.services.AuthorService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class AuthorModel {

    private AuthorService authorService;

    public AuthorService getAuthorService() {
        return authorService;
    }

    @EJB
    public void setAuthorService(AuthorService authorService){
        this.authorService = authorService;
        }

    public List<Author> returnAllAuthors(){
        return getAuthorService().returnAllAuthors();
    }

    public void addAuthor(Author a){
        authorService.addAuthor(a);
    }

    public void delAuthor(Integer id){
        authorService.delAuthor(id);
    }

    public void updAuthor(Author a){
        authorService.updAuthor(a);
    }
}
