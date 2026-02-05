package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product, Long categoryId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Long categoryId);
}
