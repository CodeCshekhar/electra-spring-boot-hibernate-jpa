package com.electra.controller;

import com.electra.domain.Brand;
import com.electra.service.BrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/brands")
public class BrandController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> retrieveBrands() {
        logger.info("Retrieving all brands");
        return ResponseEntity.ok(brandService.retrieveBrands());
    }

    @PostMapping
    public ResponseEntity<Brand> storeBrand(@RequestBody Brand brand) {
        logger.info("Storing brand");
        return ResponseEntity.ok(brandService.storeBrand(brand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable long id) {
        logger.info("Deleting brand with id: {}", id);
        return ResponseEntity.ok(brandService.deleteBrand(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Brand>> search(@PathVariable long id) {
        logger.info("Searching for brand with id: {}", id);
        return ResponseEntity.ok(brandService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable long id, @RequestBody Brand brand) {
        logger.info("Updating brand with id: {}", id);
        return ResponseEntity.ok(brandService.updateBrand(brand));
    }
}
