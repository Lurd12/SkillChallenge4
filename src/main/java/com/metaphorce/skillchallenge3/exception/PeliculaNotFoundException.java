/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package com.metaphorce.skillchallenge3.exception;

/**
 *
 * @author lur
 */
public class PeliculaNotFoundException extends RuntimeException {

	/**
	 * Creates a new instance of <code>PeliculaNotFoundException</code>
	 * without detail message.
	 */
	public PeliculaNotFoundException() {
	}

	/**
	 * Constructs an instance of <code>PeliculaNotFoundException</code> with
	 * the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public PeliculaNotFoundException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return "Pelicula no encontrada";
	}
	
	
	
}
