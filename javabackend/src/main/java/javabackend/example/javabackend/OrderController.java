package javabackend.example.javabackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @GetMapping("/Orders")
    public String index() {
        return "This is a test";
    }




}
