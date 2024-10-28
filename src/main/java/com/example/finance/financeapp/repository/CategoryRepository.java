package com.example.finance.financeapp.repository;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByType(CategoryType type);
}
