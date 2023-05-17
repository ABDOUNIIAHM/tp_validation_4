package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.Invoice;
import com.example.tp_validation_4.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAllByClientId(long id){
        return invoiceRepository.findAllByClient_Id(id);
    }
    public List<Invoice> getAllBeforeDeadLine(LocalDate date){
        return invoiceRepository.findAllByDeadLineBefore(date);
    }
    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }
    public Invoice create(Invoice invoice){
        LocalDate deadline = invoice.getInvoiceDate().plusMonths(1);
        invoice.setDeadLine(deadline);
        return invoiceRepository.save(invoice);
    }
}
