package com.example.demoo;

// import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoo.model.Products;

@RestController
@RequestMapping

public class ProductResource {
    
    @GetMapping("/all")
    public List<Products> getAll() {
        
    }
 
}