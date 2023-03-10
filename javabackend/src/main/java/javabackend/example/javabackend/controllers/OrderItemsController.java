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

    @Autowired
    private OrderItemsService orderItemsService;

    public OrderItemsController(OrderItemsService OrderItemsService) {
        super();
        this.orderItemsService = OrderItemsService;
    }


    @Autowired
    private ordersItemRepository ordersItemRepository;

//    // @GetMapping("/orders/{order_id}/order-items")
//    // public String getOrderItemsByOrderId(@PathVariable("order_id") int orderId,
//    // Model model) {
//    // List<order_items> order_items = ordersItemRepository.findByOrder_Id(orderId);
//    // model.addAttribute("order_items", order_items);
//    // return "Order-Items";
//    // }
//
//    @GetMapping("/test")
//    public String test(Model model) {
//        List<order_items> orderItems = orderItemsService.getAllOrderItems();
//        model.addAttribute("order_items", orderItems);
//        return "Orders-Items";
//    }

    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("order-items", orderItemsService.getAllOrderItems());
        return "Orders-Item";
    }



}
