package com.example.finance.financeapp.service;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.CategoryType;
import com.example.finance.financeapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategoriesByType(CategoryType type) {
        return categoryRepository.findByType(type);
    }

}
