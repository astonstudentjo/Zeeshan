package javabackend.example.javabackend.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import javabackend.example.javabackend.models.Products;
import javabackend.example.javabackend.repositories.ProductsRepository;

@Service
public class ProductsServiceImplementation implements ProductsService {

    private ProductsRepository productsRepository;

    public ProductsServiceImplementation(ProductsRepository productsRepository){
        super();
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Products> getAllProducts(){
        return productsRepository.findAll();

    }

    @Override
    public Products saveProduct(Products product){
        return productsRepository.save(product);

    }

    
}
