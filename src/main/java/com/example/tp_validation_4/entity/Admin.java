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
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    //@OneToMany
    //    private List<Product> products;

    //@OneToMany
    //    @JoinColumn(name = "idAdmin")
    //    private List<Client> clients = new ArrayList<>();

    //@OneToMany
    //    @JoinColumn(name = "idAdmin")
    //    private List<Invoice> invoices = new ArrayList<>();

}
