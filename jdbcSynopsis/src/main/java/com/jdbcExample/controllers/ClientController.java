package com.jdbcExample.controllers;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping("/v1/clients")
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public ResponseEntity<List<Client>> getClients(){
        try {
            List<Client> clients = clientService.getClients();
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Integer id){
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<Client> createClient(@RequestBody ClientDTO clientDto){
        try {
            Client client = clientService.createClient(clientDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(client);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
