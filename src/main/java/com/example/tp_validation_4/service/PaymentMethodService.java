package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.PaymentMethod;
import com.example.tp_validation_4.repository.PaymentMethodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentMethodService {
    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethod getByName(String name){
        return paymentMethodRepository.findByNameEqualsIgnoreCase(name);
    }

}
