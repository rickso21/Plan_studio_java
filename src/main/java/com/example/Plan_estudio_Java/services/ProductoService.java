package com.example.Plan_estudio_Java.services;


import com.example.Plan_estudio_Java.model.*;
import com.example.Plan_estudio_Java.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {


    @Autowired 
    private ProductoRepository productoRepository;
    
    public List<Producto> listarTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto>buscarPorId(Long id){
        return productoRepository.findById(null);
    }

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
    }

    public void eliminar (Long Id){
        productoRepository.deleteById(Id);
    }

      public Producto actualizar(Long id, Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }
}


/*
@Service: Marca esta clase como componente de servicio (Spring la detecta y la inyecta donde se necesite).

El método actualizar busca el producto, modifica sus campos y guarda. Si no existe, lanza excepción.


*/