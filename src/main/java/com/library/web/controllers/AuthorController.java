package com.library.web.controllers;

import com.library.persistence.Author;
import com.library.web.model.AuthorModel;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;


@ManagedBean
@RequestScoped
public class AuthorController {

    @EJB
    private AuthorModel authorModel;

    private List<Author> list;
    private Author selectedAuthor;
    private List<Author> selectedAuthors;
    private Author newAuthor;

    private Integer id;
    private String name;
    private String city;

    @PostConstruct
    public void init(){
        list=authorModel.returnAllAuthors();
    }

    // add new author
    public void addAuthor() throws Exception{
        newAuthor = new Author(id,name,city);
        authorModel.addAuthor(newAuthor);
    }

    // remove marked authors
    public void delAuthor(){
        for (int i = 0; i < selectedAuthors.size(); i++)
            authorModel.delAuthor(selectedAuthors.get(i).getId());

    }

    // author edit
    public void updAuthor(Author author){
        authorModel.updAuthor(author);
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Author number " + ((Author)event.getObject()).getId() + " edited.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        Author author;
        author = (Author)event.getObject();
        updAuthor(author);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit author number " + ((Author)event.getObject()).getId() + " is canceled.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Author getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Author newAuthor) {
        this.newAuthor = newAuthor;
    }

    public List<Author> getList(){
        return list;
    }

    public void setList(List<Author> list){
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public List<Author> getSelectedAuthors() {
        return selectedAuthors;
    }

    public void setSelectedAuthors(List<Author> selectedAuthors) {
        this.selectedAuthors = selectedAuthors;
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