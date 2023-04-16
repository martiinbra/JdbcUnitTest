package com.jdbcExample.jdbcExample.models.repositories;

import com.jdbcExample.models.dto.ProductDTO;;
import com.jdbcExample.models.entities.Product;
import com.jdbcExample.models.repositories.impl.ProductRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryImplTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ProductRepositoryImpl productRepositoryImpl;



    @Test
    public void testGetProducts() {
        List<Product> products = productRepositoryImpl.getProducts();
        assertNotNull(products);
        assertEquals(2, products.size());
    }

    @Test
    public void testGetProductById() {
        Product product = productRepositoryImpl.getProductById(1);
        assertNotNull(product);
        assertEquals("producto Camisa de buena calidad", product.getDescription());
        assertEquals(100.00, product.getCost());
    }
/*
    @Test
    public void testCreateProduct() {
        ProductDTO productDTO = new ProductDTO();
        ProductDTO.setDescription("un producto nuevo");
        ProductDTO.setCost(150.00);

        Product createdProduct = productRepositoryImpl.createProduct(new Product(productDTO));
        assertNotNull(createdProduct);
        assertNotNull(createdProduct.getId());
        assertEquals("un producto nuevo", createdProduct.getDescription());
        assertEquals(150.00, createdProduct.getCost());
    }*/
/*
    @Test
    public void testUpdateProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription("un producto nuevo");
        productDTO.setCost(150.00);

        Product createdProduct = productRepositoryImpl.createProduct(new Product(productDTO));
        createdProduct.setDescription("un producto viejo");
        createdProduct.setCost(120.00);

        Product updatedProduct = productRepositoryImpl.updateProduct(createdProduct);
        assertNotNull(updatedProduct);
        assertEquals("un producto viejo", updatedProduct.getDescription());
        assertEquals(120.00, updatedProduct.getCost());
    }*/

    @Test
    public void testDeleteClient() {
        // Crear un producto de prueba
        ProductDTO productDTO = new ProductDTO("un producto que no existe", 250.00);
        ProductRepositoryImpl repository = new ProductRepositoryImpl(jdbcTemplate);
        Product product = repository.createProduct(new Product(productDTO));
        int idProduct = product.getId();

        // Eliminar el producto
        repository.deleteProduct(idProduct);

        // Verificar que el cliente ya no existe
        assertNull(repository.getProductById(idProduct));
    }
}