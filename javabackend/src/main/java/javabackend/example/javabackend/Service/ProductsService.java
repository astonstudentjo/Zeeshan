package javabackend.example.javabackend.Service;

import java.util.List;

import javabackend.example.javabackend.models.Products;

public interface ProductsService {
    List<Products> getAllProducts();

    Products saveProduct(Products product);
    
}
