package com.example.tp_validation_4.controller;

import com.example.tp_validation_4.entity.Address;
import com.example.tp_validation_4.entity.Client;
import com.example.tp_validation_4.form.ClientForm;
import com.example.tp_validation_4.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @GetMapping
    public String getAllClients(Model model){

        List<Client> clients =
                clientService.getAllClients();

        model.addAttribute("clients",clients);
        return "list-client";
    }
    @GetMapping("/add-client")
    public String getFormClient(Model model){

        ClientForm clientForm = new ClientForm();
        model.addAttribute("clientForm",clientForm);

        return "add-client";
    }
    @PostMapping
    public String addClient(@ModelAttribute("clientForm") ClientForm clientForm){

        Address address = clientForm.getAddress();
        Client client = clientForm.getClient();

        client.setAddress(address);
        clientService.create(client);

        return "redirect:/client";
    }

}
