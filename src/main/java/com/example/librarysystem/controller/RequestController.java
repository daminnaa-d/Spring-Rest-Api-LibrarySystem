package com.example.librarysystem.controller;

import com.example.librarysystem.entity.Request;
import com.example.librarysystem.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("")
    public List<Request> getAllRequests(){
        return requestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Request getRequest(@PathVariable Long id) {
        return requestRepository.findById(id).get();
    }

    @PostMapping("")
    public Request addNewRequest(@RequestBody Request request){
        return requestRepository.save(request);

    }

    @PutMapping("/{id}")
    public Request updateRequest(@PathVariable Long id,
                               @RequestBody Request request){
        request.setRequest_id(id);
        return requestRepository.saveAndFlush(request);
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id){
        requestRepository.deleteById(id);
        return "Request with ID: " + id + ", was deleted!";
    }
}
