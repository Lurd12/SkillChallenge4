/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.metaphorce.skillchallenge3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author lur
 */


@Entity
@Table(name = "pelicula")
public class Pelicula {
	@Id
	private int id;
	@NotNull(message="El titulo no debe ser nulo")
	@NotEmpty(message = "El titulo no debe estar vacio")
	private String nombre;
	@NotNull(message = "La disponibilidad no debe ser nula")
	private boolean disponible;

	public Pelicula(){}
	
	public Pelicula(int id, String nombre, boolean disponible) {
		this.id = id;
		this.nombre = nombre;
		this.disponible = disponible;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
}
