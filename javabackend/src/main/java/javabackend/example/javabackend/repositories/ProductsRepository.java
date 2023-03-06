package javabackend.example.javabackend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import javabackend.example.javabackend.models.Products;

public interface ProductsRepository extends CrudRepository<Products, Long> {
    List<Products> findAll();

    
    
    

    
}
