package com.example.tp_validation_4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String enterprise;
    private String phone;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idAdress")
    private Address address;
    @OneToMany(mappedBy = "client")
    private List<Invoice> invoices = new ArrayList<>();


}
