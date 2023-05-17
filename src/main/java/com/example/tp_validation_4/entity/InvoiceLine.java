package com.example.tp_validation_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "idInvoice")
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
    private int quantity;
}
