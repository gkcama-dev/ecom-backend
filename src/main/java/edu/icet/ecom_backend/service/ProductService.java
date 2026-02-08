package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    Product createProduct(Product product, MultipartFile image, Long categoryId) throws IOException;
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Long categoryId);

}
