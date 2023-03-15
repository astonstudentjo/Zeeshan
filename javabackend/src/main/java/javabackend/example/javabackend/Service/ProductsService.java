package javabackend.example.javabackend.Service;

import java.util.List;

import javabackend.example.javabackend.models.Products;

public interface ProductsService {
    List<Products> getAllProducts();

    Products saveProduct(Products product);

    void deleteProductById(Integer id);

    Products getProductById(Integer id);

    Products updateProduct(Products product);

    Products generateStockReportPdf(List<Products> products);

    List<Products> findByKeyword(String keyword);
}
