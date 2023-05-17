package com.example.tp_validation_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String designation;
    private BigDecimal unitPrice;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "product")
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
}
