package com.example.tp_validation_4.form;

import com.example.tp_validation_4.entity.Address;
import com.example.tp_validation_4.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@Getter @Setter
public class ClientForm {
    private Client client;
    private Address address;

    public ClientForm() {
        this.client = new Client();
        this.address = new Address();
    }
}
