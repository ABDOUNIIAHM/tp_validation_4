package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.Address;
import com.example.tp_validation_4.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address getById(long id){
        return addressRepository.findById(id).orElseThrow(()->new RuntimeException("No Address found for id:"+id));
    }
}
