package com.example.tp_validation_4.repository;

import com.example.tp_validation_4.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository< Invoice,Long> {
    List<Invoice> findAllByClient_Id(long idClient);
    List<Invoice> findAllByDeadLineBefore(LocalDate deadline);
}
