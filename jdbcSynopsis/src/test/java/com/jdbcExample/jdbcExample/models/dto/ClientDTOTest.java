package com.jdbcExample.jdbcExample.models.dto;
import static org.junit.jupiter.api.Assertions.*;

import com.jdbcExample.models.dto.ClientDTO;
import org.junit.jupiter.api.Test;

public class ClientDTOTest {

    @Test
    public void testConstructorAndGetters() {
        ClientDTO client = new ClientDTO("John Smith", "123456789");
        assertEquals("John Smith", client.getName());
        assertEquals("123456789", client.getPhone());
    }

    @Test
    public void testSetters() {
        ClientDTO client = new ClientDTO("John Smith", "123456789");
        client.setName("Jane Doe");
        client.setPhone("987654321");
        assertEquals("Jane Doe", client.getName());
        assertEquals("987654321", client.getPhone());
    }
}
