package javabackend.example.javabackend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javabackend.example.javabackend.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
   
    //List<Products> findAll();

    @Query("SELECT p FROM Products p WHERE p.name LIKE %?1%"
            + " OR p.category LIKE %?1%"
            + " OR CONCAT(p.artist, '') LIKE %?1%")
    public List<Products> search(String keyword);

    


    
    
    

    
}
