package javabackend.example.javabackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getOrders() {
       
        return "home-page";
    }

    
    
}
