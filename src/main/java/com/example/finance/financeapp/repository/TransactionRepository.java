package com.example.finance.financeapp.repository;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public boolean existsByCategory(Category category);
}
