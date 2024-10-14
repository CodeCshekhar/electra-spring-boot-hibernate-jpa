package com.electra.service;


import com.electra.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel saveProduct(ProductModel product);
    boolean deleteProduct(final Long productId);
    List<ProductModel> getAllProducts();
    ProductModel getProductById(final Long productId);
}
