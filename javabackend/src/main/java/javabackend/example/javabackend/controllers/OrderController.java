package javabackend.example.javabackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javabackend.example.javabackend.repositories.ordersRepository;
import javabackend.example.javabackend.models.orders;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class OrderController {

    @Autowired
    private ordersRepository ordersRepository;


    @GetMapping("/Orders")
//    public String index() {
//        return "This is a test";
//    }

    public String getOrders(Model model) {
        List<orders> orders = ordersRepository.findAll();
        System.out.println("Number of orders: " + orders.size());
        model.addAttribute("orders", orders);
        return "Orders-Page";
    }





}
