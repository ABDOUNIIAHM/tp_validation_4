package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.Product;
import com.example.tp_validation_4.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }
    public Product getById(long id){
        return productRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("No such product found for id:"+id));
    }
    public Product create(Product product){
        return productRepository.save(product);
    }
}
