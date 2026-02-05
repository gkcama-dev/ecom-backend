package edu.icet.ecom_backend.service.impl;

import edu.icet.ecom_backend.model.Category;
import edu.icet.ecom_backend.model.Product;
import edu.icet.ecom_backend.repository.CategoryRepository;
import edu.icet.ecom_backend.repository.ProductRepository;
import edu.icet.ecom_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        }

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
}
