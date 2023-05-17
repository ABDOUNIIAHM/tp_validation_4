package com.example.tp_validation_4.service;

import com.example.tp_validation_4.entity.Client;
import com.example.tp_validation_4.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client getClientById(long id){

        return clientRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("No such client found for id:"+id));
    }
    public List<Client> getAllClients(){

        return clientRepository.findAll();
    }
    public List<Client> getAllClientByEnterprise(String name){

        return clientRepository.findClientByEnterpriseIsContainingIgnoreCase(name);
    }
}
