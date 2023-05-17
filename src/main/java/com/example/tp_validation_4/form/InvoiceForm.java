package com.example.tp_validation_4.form;

import com.example.tp_validation_4.entity.Client;
import com.example.tp_validation_4.entity.Invoice;
import com.example.tp_validation_4.entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvoiceForm {
    private Invoice invoice;
    private Client client;
    private PaymentMethod paymentMethod;

    public InvoiceForm() {
        this.invoice = new Invoice();
        this.client = new Client();
        this.paymentMethod = new PaymentMethod();
    }
}
