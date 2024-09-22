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
@RequestMapping("/electra/brand")
public class BrandController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand> getAllBrands() {
        logger.info("Retrieving Brands from Get in Controller");
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        logger.info("Retrieving Brand from Get by ID in Controller");
        Brand brand = brandService.getBrandById(id);
        if (brand != null) {
            return ResponseEntity.ok(brand);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Brand createBrand(@RequestBody Brand brand) {
        logger.info("Creating Brand from Post in Controller");
        return brandService.createBrand(brand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brand) {
        logger.info("Updating Brand from Put in Controller");
        Brand updatedBrand = brandService.updateBrand(id, brand);
        if (updatedBrand != null) {
            return ResponseEntity.ok(updatedBrand);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrand(@PathVariable Long id) {
        logger.info("Deleting Address from delete in Controller");
        brandService.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}
