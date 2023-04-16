package com.jdbcExample.models.services;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getClients();
    Client getClientById(Integer idClient);
    Client createClient(ClientDTO client);
    Client updateClient(ClientDTO clientDTO, Integer idClient);
    void deleteClient(Integer idClient);

}

