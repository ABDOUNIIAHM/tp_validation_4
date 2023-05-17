package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.InvoiceLine;
import com.example.tp_validation_4.repository.InvoiceLineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceLineService {
    private final InvoiceLineRepository invoiceLineRepository;

    public InvoiceLine getInvoiceLineByInvoiceAndProductId(long idInvoice, long idProduct){

        return invoiceLineRepository
                .findInvoiceLineByInvoice_IdAndProduct_Id(idInvoice, idProduct);
    }
    public List<InvoiceLine> getAllInvoiceLinesByInvoiceId(long idInvoice){

        return invoiceLineRepository
                .findAllByInvoice_Id(idInvoice);
    }
    public InvoiceLine create(InvoiceLine invoiceLine){
        return invoiceLineRepository.save(invoiceLine);
    }
}
