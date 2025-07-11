/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.skillchallenge3.controller;

import com.metaphorce.skillchallenge3.exception.DatosNoValidosException;
import com.metaphorce.skillchallenge3.exception.PeliculaNotFoundException;
import com.metaphorce.skillchallenge3.model.Pelicula;
import com.metaphorce.skillchallenge3.service.PeliculaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author lur
 */
@RestController
public class PeliculaController {
	@Autowired
	PeliculaService peliculaService;
	
	/**
	 * Agrega una pelicula a la base de datos
	 */
	@PostMapping("/peliculas")
	public ResponseEntity<?> agregarPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			throw new DatosNoValidosException("Error de validación", bindingResult);
		}
		return new ResponseEntity<>(peliculaService.agregarPelicula(pelicula), HttpStatus.OK);
	}
	
	
	/**
	 * Elimina una pelicula por su id
	 * 
	 */
	@DeleteMapping("/pelicula/{id}")
	public ResponseEntity<?>  eliminarPelicula(@PathVariable int id){
		peliculaService.eliminarPelicula(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Obtiene todas las peliculas
	 * 
	 */	
	@GetMapping("/peliculas")
	public ResponseEntity<List<Pelicula>> obtenerPeliculas(){
		return new ResponseEntity<>(peliculaService.obtenerPeliculas(), HttpStatus.OK);
	}

	/**
	 * Obtiene todas la pelicula disponibles
	 * 
	 */
	@GetMapping("/peliculas/disponible")
	public ResponseEntity<List<Pelicula>> obtenerPeliculasDisponibles(){
		return new ResponseEntity<>(peliculaService.obtenerPeliculasPorDisponibilidad(true), HttpStatus.OK);
	}
	/**
	 * Obtiene todas la pelicula  no disponibles
	 * 
	 */
	@GetMapping("/peliculas/nodisponible")
	public ResponseEntity<List<Pelicula>> obtenerPeliculasNoDisponibles(){
		return new ResponseEntity<>(peliculaService.obtenerPeliculasPorDisponibilidad(false), HttpStatus.OK);
	}

	/**
	 * Obtiene una pelicula por su id
	 * 
	 */
	@GetMapping("/pelicula/{id}")
	public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable
		int id){
			return new ResponseEntity<>(peliculaService.obtenerPeliculaPorId(id), HttpStatus.OK);
	}
	
	
	/**
	 * Marca una pelicula como disponible
	 * 
	 */
	@PutMapping("/pelicula/{id}")
	public ResponseEntity<?> marcharComoDisponible(@PathVariable int id){
			peliculaService.marcarPeliculaComoDisponible(id);
			return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Modifica una pelicula
	 * 
	 */
	@PutMapping("pelicula")
	public ResponseEntity<?> modificarPelicula(@RequestBody Pelicula pelicula){
			return new ResponseEntity<>(peliculaService.modificarPelicula(pelicula), HttpStatus.OK);
	}
	
	
}
