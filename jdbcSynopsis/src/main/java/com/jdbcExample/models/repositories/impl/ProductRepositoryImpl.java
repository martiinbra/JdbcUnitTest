package com.jdbcExample.models.repositories.impl;

import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.entities.Product;
import com.jdbcExample.models.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
    }
    @Override
    public List<Product> getProducts() {
        String sql = "CALL Product_list_all();";
        return jdbcTemplate.query(sql, new ProductRepositoryImpl.ProductMapper());
    }

    @Override
    public Product getProductById(Integer idProduct) {
        String sql = "CALL Product_get_by_id(?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{idProduct}, new ProductRepositoryImpl.ProductMapper());
    }

    @Override
    public Product createProduct(Product product) {
        String sql = "CALL Product_create(?, ?)";
        jdbcTemplate.update(sql, product.getDescription(), product.getCost());
        return product;
    }

    @Override
    public Client updateProduct(Product product, Integer idProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Integer idProduct) {

    }

    private static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setDescription(rs.getString("description"));
            product.setCost(rs.getDouble("cost"));
            return product;
        }
    }
}
