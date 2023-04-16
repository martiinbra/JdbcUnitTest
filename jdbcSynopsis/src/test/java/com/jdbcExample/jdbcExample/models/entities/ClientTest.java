package com.jdbcExample.jdbcExample.models.entities;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    public void testConstructor() {
        ClientDTO clientDTO = new ClientDTO("John Doe", "1234567890");
        Client client = new Client(clientDTO);

        Assertions.assertEquals(clientDTO.getName(), client.getName());
        Assertions.assertEquals(clientDTO.getPhone(), client.getPhone());
    }
}
