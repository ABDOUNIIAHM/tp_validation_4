package com.example.tp_validation_4.repository;

import com.example.tp_validation_4.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod,Long> {
    PaymentMethod findByNameEqualsIgnoreCase(String name);
}
