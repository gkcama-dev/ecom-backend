package edu.icet.ecom_backend.controller;

import edu.icet.ecom_backend.model.Product;
import edu.icet.ecom_backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add/{categoryId}")
    public Product addProduct(@RequestBody Product product, @PathVariable Long categoryId) {
        return productService.createProduct(product, categoryId);
    }
}
