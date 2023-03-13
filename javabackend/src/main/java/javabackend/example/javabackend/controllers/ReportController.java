package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.Service.ProductsService;
import javabackend.example.javabackend.models.Products;
import javabackend.example.javabackend.repositories.ProductsRepository;
import javabackend.example.javabackend.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;


import javax.swing.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class ReportController {

    private final ProductsRepository productsRepository;
    private final ProductsService productsService;

    @Autowired
    public ReportController(ProductsRepository productsRepository, ProductsService productsService) {
        super();
        this.productsRepository = productsRepository;
        this.productsService = productsService;
    }

//    This is for the main page
    @GetMapping("/Report")
    public String generateReport() {
        return "Reports";
    }

//    This is for the stock report

    @GetMapping("/Report/Stock")
    public String generateStockReport(Model model) {
        List<Products> products = productsRepository.findAll();
        model.addAttribute("products", products);
        System.out.println("Stock Report generated");
        return "Stock-Report";
    }












}
