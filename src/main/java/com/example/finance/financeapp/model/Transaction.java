package com.example.finance.financeapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trx_id")
    private Long id;

    private String description;
    private BigDecimal amount;
    private LocalDate date;

    @ManyToOne
    private Category category;

    public Transaction(String description, BigDecimal amount, LocalDate date, Category category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }

}
