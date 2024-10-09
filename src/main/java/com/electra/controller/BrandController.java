package com.electra.controller;

import com.electra.domain.Brand;
import com.electra.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electra/brands")
public class BrandController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> retrieveBrands() {
        logger.info("Retrieving all brands");
        return ResponseEntity.ok(brandService.retrieveBrands());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable long id) {
        logger.info("Retrieving brand by ID: {}", id);
        Brand brand = brandService.search(id).orElse(null);
        if (brand != null) {
            return ResponseEntity.ok(brand);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        logger.info("Creating brand");
        return ResponseEntity.ok(brandService.storeBrand(brand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable long id, @RequestBody Brand brand) {
        logger.info("Updating brand with ID: {}", id);
        return ResponseEntity.ok(brandService.updateBrand(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable long id) {
        logger.info("Deleting brand with ID: {}", id);
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
