package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Book;
import com.example.librarysystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("")
    public Book addNewBook(@RequestBody Book book){
        return bookRepository.save(book);

    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                               @RequestBody Book book){
        book.setBook_id(id);
        return bookRepository.saveAndFlush(book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "Book with ID: " + id + ", was deleted!";
    }

}
