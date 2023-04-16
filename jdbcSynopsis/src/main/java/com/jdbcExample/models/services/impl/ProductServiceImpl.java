package com.jdbcExample.models.services.impl;

import com.jdbcExample.models.dto.ProductDTO;
import com.jdbcExample.models.entities.Client;
import com.jdbcExample.models.entities.Product;
import com.jdbcExample.models.repositories.ProductRepository;
import com.jdbcExample.models.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product getProductById(Integer idProduct) {
        return productRepository.getProductById(idProduct);
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        return productRepository.createProduct(product);
    }

    @Override
    public Client updateProduct(ProductDTO productDTO, Integer idProduct) {
        return null;
    }

    @Override
    public void deleteProduct(Integer idProduct) {

    }
}

