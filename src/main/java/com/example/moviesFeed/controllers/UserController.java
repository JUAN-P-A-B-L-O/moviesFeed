/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moviesFeed.controllers;

import com.example.moviesFeed.entities.UserModel;
import com.example.moviesFeed.repositories.UserRepository;
import jakarta.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JUAN-PC
 */
//@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})


@RestController
@RequestMapping(value ="/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private PasswordEncoder encoder;
    
    
    
    @GetMapping
    public List<UserModel> findAll(){
        List<UserModel> result = repository.findAll();
        return result;
    }
    
    @GetMapping(value= "/{id}")
    public Optional<UserModel> findById(@PathVariable Long id){
        return repository.findById(id);
    }
    
    
    @PostMapping
    public ResponseEntity<UserModel> createUser(UserModel user){
        user.setName(encoder.encode(user.getName())); 
        UserModel userSaved = repository.save(user);
        return ResponseEntity.ok(userSaved);
    }
    
    @RequestMapping("/register")
    public ModelAndView registerView(){
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("registerPage.html");
        return modelandview;
    }
}