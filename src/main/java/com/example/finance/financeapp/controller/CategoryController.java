package com.example.finance.financeapp.controller;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.CategoryType;
import com.example.finance.financeapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<List<Category>> (categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Category>> getCategoriesByType(@PathVariable CategoryType type) {
        return new ResponseEntity<List<Category>>(categoryService.getCategoriesByType(type), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.OK);
    }

}
