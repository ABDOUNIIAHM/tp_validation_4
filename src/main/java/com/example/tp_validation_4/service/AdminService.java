package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.Admin;
import com.example.tp_validation_4.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin getById(long id){
        return adminRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("No such admin found for id:"+id));
    }
    public Admin getByEmail(String email){
        return adminRepository
                .findByUsername(email)
                .orElseThrow(()->new RuntimeException("No Admin found for username:"+email));
    }
}
