package com.electra.controller;

import com.electra.domain.Product;
import com.electra.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> retrieveProducts() {
        logger.info("Retrieving all products");
        return ResponseEntity.ok(productService.retrieveProducts());
    }

    @PostMapping
    public ResponseEntity<Product> storeProduct(@RequestBody Product product) {
        logger.info("Storing product");
        return ResponseEntity.ok(productService.storeProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id) {
        logger.info("Deleting product with id: {}", id);
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> search(@PathVariable long id) {
        logger.info("Searching for product with id: {}", id);
        return ResponseEntity.ok(productService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        logger.info("Updating product with id: {}", id);
        return ResponseEntity.ok(productService.updateProduct(product));
    }
}
