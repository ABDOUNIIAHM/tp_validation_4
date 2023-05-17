package com.example.tp_validation_4;

import com.example.tp_validation_4.entity.*;
import com.example.tp_validation_4.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpValidation4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TpValidation4Application.class, args);
    }
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    InvoiceLineRepository invoiceLineRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


    }
}
