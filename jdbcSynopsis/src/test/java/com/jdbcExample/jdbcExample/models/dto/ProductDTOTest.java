package com.jdbcExample.jdbcExample.models.dto;
import static org.junit.jupiter.api.Assertions.*;

import com.jdbcExample.models.dto.ProductDTO;
import org.junit.jupiter.api.Test;
public class ProductDTOTest {

    @Test
    public void testConstructorAndGetters() {
        ProductDTO product = new ProductDTO("T-shirt", 25.99);
        assertEquals("T-shirt", product.getDescription());
        assertEquals(25.99, product.getCost(), 0.01);
    }

    @Test
    public void testSetters() {
        ProductDTO product = new ProductDTO("T-shirt", 25.99);
        product.setDescription("Jeans");
        product.setCost(49.99);
        assertEquals("Jeans", product.getDescription());
        assertEquals(49.99, product.getCost(), 0.01);
    }
}
