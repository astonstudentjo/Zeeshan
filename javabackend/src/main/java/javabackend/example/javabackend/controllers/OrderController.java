package javabackend.example.javabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javabackend.example.javabackend.repositories.*;
import javabackend.example.javabackend.models.*;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrderController {

    @Autowired
    private ordersRepository ordersRepository;



    @GetMapping("/Orders")
    public String getOrders(Model model) {
        List<orders> orders = ordersRepository.findAll();
        model.addAttribute("orders", orders);
        return "Orders-Page";
    }
}
