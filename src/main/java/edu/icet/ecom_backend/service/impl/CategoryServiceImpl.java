package edu.icet.ecom_backend.service.impl;

import edu.icet.ecom_backend.model.Category;
import edu.icet.ecom_backend.repository.CategoryRepository;
import edu.icet.ecom_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}
