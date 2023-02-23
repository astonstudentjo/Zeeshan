package com.example.demoo.resource;

import java.util.List;

// import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoo.mapper.ProductMapper;
import com.example.demoo.model.Product;

@RestController
@RequestMapping("/rest/Product")

public class ProductResource {
    
    private ProductMapper productMapper;

    public ProductResource(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    @GetMapping("/all")
    public List<Product> getAll() {
       return productMapper.findAll();
    }
 
}