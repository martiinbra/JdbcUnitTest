package com.jdbcExample.models.repositories.impl;


import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ClientRepositoryImpl(JdbcTemplate jdbcTemplate) {
    }

    @Override
    public List<Client> getClients() {
        String sql = "CALL Client_list_all();";
        return jdbcTemplate.query(sql, new ClientMapper());
    }

    @Override
    public Client getClientById(Integer idClient) {
        String sql = "CALL Client_get_by_id(?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{idClient}, new ClientMapper());
    }

    @Override
    public Client createClient(Client client) {
        String sql = "CALL Client_create(?, ?)";
        jdbcTemplate.update(sql, client.getName(), client.getPhone());
        return client;
    }

    @Override
    public Client updateClient(Client client, Integer idClient) {
        return null;
    }

    @Override
    public void deleteClient(Integer idClient) {

    }

    private static final class ClientMapper implements RowMapper<Client> {
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("name"));
            client.setPhone(rs.getString("phone"));
            return client;
        }
    }
}
