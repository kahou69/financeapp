package com.example.finance.financeapp.service;

import com.example.finance.financeapp.model.Category;
import com.example.finance.financeapp.model.Transaction;
import com.example.finance.financeapp.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
    public boolean existsByCategory(Category category) {
        return transactionRepository.existsByCategory(category);
    }
}
