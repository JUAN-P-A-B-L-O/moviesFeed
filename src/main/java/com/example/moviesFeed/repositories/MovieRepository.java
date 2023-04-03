/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.moviesFeed.repositories;

import com.example.moviesFeed.entities.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JUAN-PC
 */
public interface MovieRepository extends JpaRepository<MovieModel, Long>{
    
    
}
