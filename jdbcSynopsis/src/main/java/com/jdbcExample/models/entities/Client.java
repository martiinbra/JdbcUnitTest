package com.jdbcExample.models.entities;

import com.jdbcExample.models.dto.ClientDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private int id;
    private String name;
    private String phone;

    public Client(ClientDTO clientDTO) {
        this.name = clientDTO.getName();
        this.phone =clientDTO.getPhone();
    }
}

