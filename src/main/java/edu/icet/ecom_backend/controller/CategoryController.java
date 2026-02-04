package edu.icet.ecom_backend.controller;

import edu.icet.ecom_backend.model.Category;
import edu.icet.ecom_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
}
