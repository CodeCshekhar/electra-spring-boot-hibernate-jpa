package com.electra.service;

import com.electra.domain.Product;
import com.electra.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        logger.info("Products Retrieved in Services");
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        logger.info("Product detected by ID in Services");
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        logger.info("Product Created in Services");
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            product.setName(updatedProduct.getName());
            product.setDescription(updatedProduct.getDescription());
            product.setPrice(updatedProduct.getPrice());
            product.setBrand(updatedProduct.getBrand());
            logger.info("Payment Updated in Services");
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        logger.info("Payment deleted");
        productRepository.deleteById(id);
    }
}
