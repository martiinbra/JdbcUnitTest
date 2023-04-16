package com.jdbcExample.jdbcExample.models.entities;

import com.jdbcExample.models.dto.ProductDTO;
import com.jdbcExample.models.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testConstructor() {
        ProductDTO productDTO = new ProductDTO("Sample product", 10.5);
        Product product = new Product(productDTO);

        Assertions.assertEquals(productDTO.getDescription(), product.getDescription());
        Assertions.assertEquals(productDTO.getCost(), product.getCost());
    }
}