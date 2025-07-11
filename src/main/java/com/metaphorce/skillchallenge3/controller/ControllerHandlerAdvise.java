package com.metaphorce.skillchallenge3.controller;

import com.metaphorce.skillchallenge3.exception.DatosNoValidosException;
import com.metaphorce.skillchallenge3.exception.PeliculaNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerAdvise {
    @ExceptionHandler(DatosNoValidosException.class)
    public ResponseEntity<?> validacionEntradaDatos(DatosNoValidosException datosNoValidosException) throws DatosNoValidosException{
        Map<String,String> errores = new HashMap<>();
        datosNoValidosException.getBindingResult().getFieldErrors().forEach(f-> errores.put(f.getField(),f.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler(PeliculaNotFoundException.class)
    public ResponseEntity<?> existenciaPelicula(PeliculaNotFoundException peliculaNotFoundException){
        return ResponseEntity.badRequest().body(peliculaNotFoundException.toString());

    }

}
