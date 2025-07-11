/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.skillchallenge3.repository;

import com.metaphorce.skillchallenge3.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lur
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
    List<Pelicula> findByDisponible(boolean disponible);
}
