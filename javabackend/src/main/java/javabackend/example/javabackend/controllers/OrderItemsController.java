package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.models.orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.Service.OrderItemsService;
import javabackend.example.javabackend.repositories.*;

import java.util.List;

@Controller
public class OrderItemsController {

//    @Autowired
//    private OrderItemsService orderItemsService;

    // get the order items based on the url id
//    @GetMapping("/orderItems/{id}")
//    public String getOrderItems(@PathVariable("id") int id, Model model) {
//        List<order_items> orderItems = orderItemsService.getOrderItems(id);
//        model.addAttribute("orderItems", orderItems);
//        return "orderItems";
//    }


//    @GetMapping("/Orders")
//    public String getOrders(Model model) {
//        List<order_items> orders = ordersItemRepository.findAll();
//        model.addAttribute("orders", orders);
//        return "Orders-Page";
//    }

}
