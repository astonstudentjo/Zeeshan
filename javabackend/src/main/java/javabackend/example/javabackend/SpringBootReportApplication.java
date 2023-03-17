package javabackend.example.javabackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javabackend.example.javabackend.models.Products;
import com.javabackend.example.javabackend.repositories.ProductsRepository;
import com.javabackend.example.javabackend.service.ProductsService;



import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootJasperReportApplication {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private ReportService service;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJasperReportApplication.class, args);
    }

}