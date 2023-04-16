package com.jdbcExample.models.services;

import com.jdbcExample.models.dto.ClientDTO;
import com.jdbcExample.models.dto.ProductDTO;
import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer idProduct);
    Product createProduct(ProductDTO productDTO);
    Client updateProduct(ProductDTO productDTO, Integer idProduct);
    void deleteProduct(Integer idProduct);
}
