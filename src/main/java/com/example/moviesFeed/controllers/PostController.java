/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moviesFeed.controllers;

import com.example.moviesFeed.entities.PostModel;
import com.example.moviesFeed.entities.UserModel;
import com.example.moviesFeed.repositories.PostRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JUAN-PC
 */

@RestController
@RequestMapping(value="/posts")
public class PostController {
    
    
    
    @Autowired
    PostRepository repository;
    
    
    @GetMapping
    public List<PostModel> findAll(){
        return repository.findAll();
    }
    
    
    @GetMapping(value= "/{id}")
    public Optional<PostModel> findById(@PathVariable Long id){
        return repository.findById(id);
    }
    
}
