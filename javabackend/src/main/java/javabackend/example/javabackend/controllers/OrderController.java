package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.OrdersService;
import javabackend.example.javabackend.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javabackend.example.javabackend.repositories.*;
import javabackend.example.javabackend.models.*;
import java.util.List;
import java.util.Optional;
import javabackend.example.javabackend.Service.OrdersService;

import org.springframework.ui.Model;

@Controller
public class OrderController {

    @Autowired
    private ordersRepository ordersRepository;


    private OrdersService ordersService;

    public OrderController(OrdersService ordersService){
        super();
        this.ordersService = ordersService;
    }



    @GetMapping("/Orders")
    public String getOrders(Model model) {
        List<orders> orders = ordersRepository.findAll();
        model.addAttribute("orders", orders);
        return "Orders-Page";
    }

    @GetMapping("/Orders/status/{id}")
    public String updateStatus(@PathVariable("id") int orderId, Model model){
        Optional<orders> orderOptional = ordersRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            orders order = orderOptional.get();
            String currentStatus = order.getStatus();
            model.addAttribute("orderId", orderId);
            model.addAttribute("currentStatus", currentStatus);
            return "Orders-Status";
        } else {
            // handle case when order is not found
            return "Error-Page";
        }
    }

    @PostMapping("/Orders/status/{id}")
    public String updateStatus(@PathVariable Integer id, @ModelAttribute("orders") orders orders, Model model){
        orders preExistingOrder = ordersService.getOrdersById(id);
        preExistingOrder.setStatus(orders.getStatus());
        ordersService.updateOrders(preExistingOrder);
        return "redirect:/Orders";
    }









}
