package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Product;

public interface ProductService {
    Product createProduct(Product product, Long categoryId);
}
