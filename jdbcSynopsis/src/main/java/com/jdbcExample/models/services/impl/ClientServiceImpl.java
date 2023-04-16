package com.jdbcExample.models.services.impl;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.repositories.ClientRepository;
import com.jdbcExample.models.services.ClientService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    @Override
    public Client getClientById(Integer idClient) {
        return clientRepository.getClientById(idClient);
    }

    @Override
    public Client createClient(ClientDTO clientDto) {
        Client client = new Client(clientDto);
        return clientRepository.createClient(client);
    }

    @Override
    public Client updateClient(ClientDTO client, Integer idClient) {
        return null;
    }

    @Override
    public void deleteClient(Integer idClient) {
    }

}
