package com.example.tp_validation_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate invoiceDate = LocalDate.now();
    private LocalDate deadLine = invoiceDate.plusMonths(1);
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_paymentMethod")
    private PaymentMethod paymentMethod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "invoice")
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
}
