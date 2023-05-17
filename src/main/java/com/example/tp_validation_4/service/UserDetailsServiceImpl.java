package com.example.tp_validation_4.service;

import com.example.tp_validation_4.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserDetails userDetails = adminRepository
                .findByUsername(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email"+ email+" not found !"));
        return userDetails;

    }
}
