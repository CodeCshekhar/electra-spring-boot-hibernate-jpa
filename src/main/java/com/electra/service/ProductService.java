package com.electra.service;

import com.electra.domain.Product;
import com.electra.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repo;

    public List<Product> retrieveProducts() {
        logger.info("Inside ProductService.retrieveProducts()");
        return repo.findAll();
    }

    public Product storeProduct(Product product) {
        logger.info("Inside ProductService.storeProduct()");
        return repo.save(product);
    }

    public void deleteProduct(long id) {
        logger.info("Inside ProductService.deleteProduct()");
        repo.deleteById(id);
    }

    public Optional<Product> search(long id) {
        logger.info("Inside ProductService.search()");
        return repo.findById(id);
    }

    public Product updateProduct(Product product) {
        logger.info("Inside ProductService.updateProduct()");
        return repo.save(product);
    }
}
