package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.OrdersService;
import javabackend.example.javabackend.models.orders;
import javabackend.example.javabackend.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    public OrdersRepository ordersRepository;




    private OrdersService ordersService;

    public OrderController(OrdersService ordersService){
        super();
        this.ordersService = ordersService;
    }

    public void GetOrdersRepository() {
        this.ordersRepository = ordersRepository; // using this for tests
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
            return "Error-Page";
        }
    }

    @PostMapping("/Orders/status/{id}")
    public String updateStatus(@PathVariable Integer id, @ModelAttribute("orders") orders orders, Model model){
        orders preExistingOrder = ordersService.getOrdersById(id);
        preExistingOrder.setStatus(orders.getStatus());
//        get current date and time and set it to the updated_at field
        preExistingOrder.setUpdated_at(Timestamp.valueOf(java.time.LocalDateTime.now()));
        ordersService.updateOrders(preExistingOrder);

        return "redirect:/Orders";
    }

    @PostMapping("/Orders/filter")
    public String filterOrders(@RequestParam("filter") String status, Model model) {
        List<orders> orders = ordersRepository.findAll();
        if (status.equals("all")) {
            orders = ordersRepository.findAll();
            model.addAttribute("orders", orders);
            return "Orders-Page";
        }

        if (status.equals("pending")) {
            orders.removeIf(order -> !order.getStatus().equals("pending"));
            model.addAttribute("orders", orders);
            return "Orders-Page";
        }


        if (status.equals("Cancelled")) {
            orders.removeIf(order -> !order.getStatus().equals("Cancelled"));
            model.addAttribute("orders", orders);
            return "Orders-Page";
        }

        if (status.equals("Processing")) {
            orders.removeIf(order -> !order.getStatus().equals("Processing"));
            model.addAttribute("orders", orders);
            return "Orders-Page";
        }

        if (status.equals("Shipped")) {
            orders.removeIf(order -> !order.getStatus().equals("Shipped"));
            model.addAttribute("orders", orders);
            return "Orders-Page";
        }


        orders.removeIf(order -> !order.getStatus().equals(status));


        model.addAttribute("orders", orders);
        return "Orders-Page";
    }


//    for searching the orders
    @PostMapping("/Orders/search")
    public String searchOrders(@RequestParam("search") String search, Model model) {
        List<orders> orders = ordersRepository.findAll();
        orders.removeIf(order -> !order.getId().toString().equals(search) && !order.getUser_id().toString().equals(search));
        model.addAttribute("orders", orders);
        return "Orders-Page";
    }











}
