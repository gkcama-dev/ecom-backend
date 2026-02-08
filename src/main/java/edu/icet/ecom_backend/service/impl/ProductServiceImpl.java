package edu.icet.ecom_backend.service.impl;

import edu.icet.ecom_backend.model.Category;
import edu.icet.ecom_backend.model.Product;
import edu.icet.ecom_backend.repository.CategoryRepository;
import edu.icet.ecom_backend.repository.ProductRepository;
import edu.icet.ecom_backend.service.ImageUploadService;
import edu.icet.ecom_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageUploadService imageUploadService;


    @Override
    public Product createProduct(Product product, MultipartFile image, Long categoryId) throws IOException {

        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (category != null) {

            if (image != null && !image.isEmpty()) {
                String imageUrl = imageUploadService.uploadImage(image);
                product.setImageUrl(imageUrl);
            }
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
