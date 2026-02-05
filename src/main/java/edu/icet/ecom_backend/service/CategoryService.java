package edu.icet.ecom_backend.service;

import edu.icet.ecom_backend.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getAllCategories();
}
