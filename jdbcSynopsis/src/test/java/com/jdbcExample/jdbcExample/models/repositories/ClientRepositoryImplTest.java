package com.jdbcExample.jdbcExample.models.repositories;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.repositories.impl.ClientRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ClientRepositoryImpl clientRepositoryImpl;


    @Test
    public void testGetClients() {
        List<Client> clients = clientRepositoryImpl.getClients();
        assertNotNull(clients);
        assertEquals(2, clients.size());
    }

    @Test
    public void testGetClientById() {
        Client client = clientRepositoryImpl.getClientById(1);
        assertNotNull(client);
        assertEquals("John", client.getName());
        assertEquals("1234567890", client.getPhone());
    }

    @Test
    public void testCreateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Jane");
        clientDTO.setPhone("0987654321");

        Client createdClient = clientRepositoryImpl.createClient(new Client(clientDTO));
        assertNotNull(createdClient);
        assertNotNull(createdClient.getId());
        assertEquals("Jane", createdClient.getName());
        assertEquals("0987654321", createdClient.getPhone());
    }

    @Test
    public void testUpdateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Jane");
        clientDTO.setPhone("0987654321");

        Client createdClient = clientRepositoryImpl.createClient(new Client(clientDTO));
        createdClient.setName("Jane Smith");
        createdClient.setPhone("1111111111");

        Client updatedClient = clientRepositoryImpl.updateClient(createdClient, createdClient.getId());
        assertNotNull(updatedClient);
        assertEquals("Jane Smith", updatedClient.getName());
        assertEquals("1111111111", updatedClient.getPhone());
    }

    @Test
    public void testDeleteClient() {
        // Crear un cliente de prueba
        ClientDTO clientDTO = new ClientDTO("John Doe", "555-1234");
        ClientRepositoryImpl repository = new ClientRepositoryImpl(jdbcTemplate);
        Client client = repository.createClient(new Client(clientDTO));
        int idClient = client.getId();

        // Eliminar el cliente
        repository.deleteClient(idClient);

        // Verificar que el cliente ya no existe
        assertNull(repository.getClientById(idClient));
    }
}