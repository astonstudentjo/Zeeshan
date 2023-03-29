package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.OrderItemsService;
import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.repositories.ordersItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OrderItemsController {

    public static Model model;
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
        List<order_items> order_items = ordersItemRepository.findAll(); // causes null pointer execption.
        System.out.println("Number of order items: " + order_items.size());
        model.addAttribute("order_items", order_items);
        return "Orders-Item";
    }

    @GetMapping("/Orders/items/{id}")
    public String getSpecificItem(@PathVariable("id") Integer orderId, Model model) {
        List<order_items> orderItems = ordersItemRepository.findAll();
        List<order_items> filteredItems = orderItems.stream()
                .filter(item -> item.getOrder_id().equals(orderId))
                .collect(Collectors.toList());
        model.addAttribute("order_items", filteredItems);
        return "Orders-Item";
    }



}
