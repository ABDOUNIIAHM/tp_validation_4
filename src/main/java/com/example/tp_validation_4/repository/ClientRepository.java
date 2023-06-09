package com.example.tp_validation_4.repository;

import com.example.tp_validation_4.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findClientByEnterpriseIsContainingIgnoreCase(String name);

}
