package com.example.finance.financeapp.controller;

import com.example.finance.financeapp.model.Transaction;
import com.example.finance.financeapp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return new ResponseEntity<List<Transaction>>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return new ResponseEntity<Transaction>(transactionService.saveTransaction(transaction), HttpStatus.OK);
    }
}
