package com.example.tp_validation_4.form;

import com.example.tp_validation_4.entity.Client;
import com.example.tp_validation_4.entity.Invoice;
import com.example.tp_validation_4.entity.PaymentMethod;
import com.example.tp_validation_4.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InvoiceForm {
    private Invoice invoice;
    private Client client;
    private List<Product> product;
    private PaymentMethod paymentMethod;

    public InvoiceForm() {
        this.invoice = new Invoice();
        this.client = new Client();
        this.paymentMethod = new PaymentMethod();
    }
}
