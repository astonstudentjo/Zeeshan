package javabackend.example.javabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javabackend.example.javabackend.repositories.ProductsRepository;
import javabackend.example.javabackend.models.Products;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;


    @GetMapping("/Products")

    public String getProducts(Model model){
        List<Products> products = productsRepository.findAll();
        System.out.println("Number of Products: " + products.size());
        model.addAttribute("Products", products);
        return "Products-Page";

    

    }
}
