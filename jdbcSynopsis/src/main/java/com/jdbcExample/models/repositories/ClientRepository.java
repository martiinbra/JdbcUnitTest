package com.jdbcExample.models.repositories;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> getClients();
    Client getClientById(Integer idClient);
    Client createClient(Client client);
    Client updateClient(Client client, Integer idClient);
    void deleteClient(Integer idClient);

}
