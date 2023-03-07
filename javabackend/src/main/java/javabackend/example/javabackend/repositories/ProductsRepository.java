package javabackend.example.javabackend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import javabackend.example.javabackend.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
   
    //List<Products> findAll();

    
    
    

    
}
