package javabackend.example.javabackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private ProductsRepository productsRepository;
    @GetMapping("/")
    public String index() {
        return "Works";
    }


    @GetMapping("/all")
    public @ResponseBody Iterable<Products> getAllUsers(){
        return productsRepository.findAll();
    }
}
