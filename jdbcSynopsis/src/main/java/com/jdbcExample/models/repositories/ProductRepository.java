package com.jdbcExample.models.repositories;

import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.entities.Product;

import java.util.List;


public interface ProductRepository {
    public List<Product> getProducts();
    public Product getProductById(Integer idProduct);
    public Product createProduct(Product product);
    Client updateProduct(Product product, Integer idProduct);
    void deleteProduct(Integer idProduct);

}
