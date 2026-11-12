package com.example.Plan_estudio_Java.controller;


import com.example.Plan_estudio_Java.model.*;
import com.example.Plan_estudio_Java.services.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/productos")
public class ProductoController {

        private static final Logger log = LoggerFactory.getLogger(ProductoController.class);


    @Autowired 
    private ProductoService productoService;

    @GetMapping 
    public List<Producto>listar (){
        log.info("Listado de todos los productos");
        return productoService.listarTodos();

    }

    @GetMapping("/{id}") 
    public ResponseEntity<Producto>obterner(@PathVariable Long id){
    return productoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping 
    public Producto crear (@RequestBody Producto producto){
        log.info("Crea producto: {}", producto.getNombre());
        return productoService.guardar(producto);
    }


     @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            return ResponseEntity.ok(productoService.actualizar(id, producto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }



}

/*
¿Por qué org.slf4j.Logger y no org.apache.logging.log4j.Logger?
Porque SLF4J es una fachada (una interfaz). Tu código habla con SLF4J, y en tiempo de ejecución Log4j2 actúa como la implementación real. 
Esto es una buena práctica: si mañana quisieras cambiar a otro motor de logs, solo cambias dependencias, no el código. 
Spring Boot ya incluye SLF4J como puente .

*/