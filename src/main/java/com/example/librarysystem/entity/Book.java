package com.example.librarysystem.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;
    private String book_name;
    private String description;
    private String book_author;
    private Boolean availability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", insertable = true, updatable = false)
    @JsonIgnore
    private Request request;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "collection_id", insertable = true, updatable = false)
    @JsonIgnore
    private Collection collection;

    public Book() { }

    public Book(Long book_id, String book_name, String description, String book_author, Boolean availability, Request request, Collection collection) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.description = description;
        this.book_author = book_author;
        this.availability = availability;
        this.request = request;
        this.collection = collection;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", description='" + description + '\'' +
                ", book_author='" + book_author + '\'' +
                ", availability=" + availability +
                ", request=" + request +
                '}';
    }
}
