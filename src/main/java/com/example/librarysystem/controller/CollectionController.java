package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Collection;
import com.example.librarysystem.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collections")
public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;

    @GetMapping("")
    public List<Collection> getAllCollections(){
        return collectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Collection getCollection(@PathVariable Long id) {
        return collectionRepository.findById(id).get();
    }

    @PostMapping("")
    public Collection addNewCollection(@RequestBody Collection collection){
        return collectionRepository.save(collection);

    }

    @PutMapping("/{id}")
    public Collection updateCollection(@PathVariable Long id,
                               @RequestBody Collection collection){
        collection.setCollection_id(id);
        return collectionRepository.saveAndFlush(collection);
    }

    @DeleteMapping("/{id}")
    public String deleteCollection(@PathVariable Long id){
        collectionRepository.deleteById(id);
        return "Collection with ID: " + id + ", was deleted!";
    }

}
