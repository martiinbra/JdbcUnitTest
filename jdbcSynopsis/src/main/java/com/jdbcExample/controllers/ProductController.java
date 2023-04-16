package com.jdbcExample.controllers;

import com.jdbcExample.models.dto.ProductDTO;
import com.jdbcExample.models.entities.Product;
import com.jdbcExample.models.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/v1/products")
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts(){
        try {
            List<Product> products = productService.getProducts();
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDto){
        try {
            Product product = productService.createProduct(productDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        catch(Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
