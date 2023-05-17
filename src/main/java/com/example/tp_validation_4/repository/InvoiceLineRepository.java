package com.example.tp_validation_4.repository;

import com.example.tp_validation_4.entity.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLineRepository extends JpaRepository< InvoiceLine,Long> {
    InvoiceLine findInvoiceLineByInvoice_IdAndProduct_Id(long idInvoice, long productId);
    List<InvoiceLine> findAllByInvoice_Id(long invoiceId);
}
