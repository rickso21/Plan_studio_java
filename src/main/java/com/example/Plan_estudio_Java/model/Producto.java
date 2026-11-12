package com.example.Plan_estudio_Java.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor  
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    private Integer stock;

}
/*
@Entity: Le dice a JPA que esta clase mapea a una tabla.

@Id + @GeneratedValue: El id será autoincremental en MySQL.

@Data (Lombok): Genera getters, setters, toString, etc.
*/