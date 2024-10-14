package com.electra.controller;

import com.electra.model.ProductModel;
import com.electra.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electra")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductModel> getProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductModel getProduct(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ProductModel saveProduct(final @RequestBody ProductModel productModel){
        return productService.saveProduct(productModel);
    }

    @DeleteMapping("/product/{id}")
    public Boolean deleteProduct(@PathVariable Long id){
        return productService.deleteProduct(id);
    }
}