package javabackend.example.javabackend.controllers;

import javabackend.example.javabackend.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javabackend.example.javabackend.models.order_items;
import javabackend.example.javabackend.Service.OrderItemsService;
import javabackend.example.javabackend.repositories.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ReportGenerator {

    @Autowired
    private ReportRepository reportRepository;

    public ReportGenerator(ReportRepository reportRepository) {
        super();
        this.reportRepository = reportRepository;
    }


    @GetMapping("/ReportGenerator")
    public String generateReport() {
        System.out.println("Report generated");
        return "Report";
    }
    






}
