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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService OrderItemsService) {
        super();
        this.orderItemsService = OrderItemsService;
    }

    @Autowired
    private ordersItemRepository ordersItemRepository;




    @GetMapping("/OrderedItems")
    public String getOrdersItems(Model model) {
        List<order_items> order_items = ordersItemRepository.findAll();
        System.out.println("Number of order items: " + order_items.size()); // add this line to print the number of order items
        model.addAttribute("order_items", order_items);
        return "Orders-Item";
    }




}
