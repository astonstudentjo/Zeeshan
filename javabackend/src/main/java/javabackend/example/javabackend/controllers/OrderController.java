package javabackend.example.javabackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javabackend.example.javabackend.repositories.*;
import javabackend.example.javabackend.models.*;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/Orders/status/{id}")
    public String updateStatus(@PathVariable("id") int orderId, Model model) {
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


//    @PostMapping("/Orders/status/{id}")
//    public String updateStatus(@PathVariable("id") int id, @RequestParam("newStatus") String newStatus) {
//        Optional<orders> optionalOrder = ordersRepository.findById(id);
//        if (optionalOrder.isPresent()) {
//            orders order = optionalOrder.get();
////            orders.setStatus(newStatus);
//            ordersRepository.save(order);
//        }
//        return "redirect:/Orders";
//    }



}
