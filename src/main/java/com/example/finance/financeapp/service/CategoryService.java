package com.example.finance.financeapp.service;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.CategoryType;
import com.example.finance.financeapp.repository.CategoryRepository;
import com.example.finance.financeapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategoriesByType(CategoryType type) {
        return categoryRepository.findByType(type);
    }

    public List<Category> deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);

        if (category == null) {
            throw new RuntimeException("Category not found");
        }

        boolean isUsed =  transactionRepository.existsByCategory(category);
        if (isUsed) {
            throw new RuntimeException("Category is in used by some transaction cannot be deleted");
        }
        categoryRepository.delete(category);
        return categoryRepository.findAll();
    }

}
