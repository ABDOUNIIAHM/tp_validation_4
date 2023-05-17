package com.example.tp_validation_4.repository;

import com.example.tp_validation_4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product,Long> {
}
