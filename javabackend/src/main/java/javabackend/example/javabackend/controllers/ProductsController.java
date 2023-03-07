package javabackend.example.javabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javabackend.example.javabackend.repositories.ProductsRepository;
import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.models.Products;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class ProductsController {



    private ProductsService productsService;

    public ProductsController(ProductsService productsService){
        super();
        this.productsService = productsService;
    }


    @GetMapping("/Products")

    public String listProducts(Model model){
       model.addAttribute("products", productsService.getAllProducts());
       return "Products-Page";

    

    }
}
