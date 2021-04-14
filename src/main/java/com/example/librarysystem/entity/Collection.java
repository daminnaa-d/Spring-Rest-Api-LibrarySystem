package com.example.librarysystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collection_id;
    private String collection_name;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    public Collection() {
    }

    public Collection(Long collection_id, String collection_name, List<Book> books) {
        this.collection_id = collection_id;
        this.collection_name = collection_name;
        this.books = books;
    }

    public Long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Long collection_id) {
        this.collection_id = collection_id;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collection_id=" + collection_id +
                ", collection_name='" + collection_name + '\'' +
                ", books=" + books +
                '}';
    }
}
