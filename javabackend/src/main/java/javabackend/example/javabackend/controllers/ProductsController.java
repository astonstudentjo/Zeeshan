package javabackend.example.javabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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


    @GetMapping("/products")

    public String listProducts(Model model){
       model.addAttribute("products", productsService.getAllProducts());
       return "Products-Page";

    

    }

    @GetMapping("/products/new")

    public String createProductForm(Model model){
        Products product = new Products();
        model.addAttribute("products", product);
        return "Create-product";
        
    }


    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("products") Products products){
        productsService.saveProduct(products);
        return "redirect:/products";

    }
}
