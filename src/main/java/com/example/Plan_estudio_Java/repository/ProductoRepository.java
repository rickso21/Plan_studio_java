package com.example.Plan_estudio_Java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Plan_estudio_Java.model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long>{
        // JpaRepository ya incluye save, findAll, findById, deleteById, etc.


}

/*
Explicación:
Spring Data JPA implementa esta interfaz automáticamente. 
No necesitas escribir SQL para el CRUD básico. JpaRepository<Producto, Long> 
indica que maneja la entidad Producto cuya clave primaria es Long .

 */