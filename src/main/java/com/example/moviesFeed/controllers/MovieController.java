/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moviesFeed.controllers;

import com.example.moviesFeed.entities.MovieModel;
import com.example.moviesFeed.repositories.MovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JUAN-PC
 */

@RestController
@RequestMapping(value ="/movies")
public class MovieController {
    @Autowired
    MovieRepository repository;
    
    @GetMapping
    public List<MovieModel> findAll(){
       List<MovieModel> result = repository.findAll();
       return (result);
    }
}
