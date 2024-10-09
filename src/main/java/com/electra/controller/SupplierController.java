package com.electra.controller;

import com.electra.domain.Supplier;
import com.electra.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electra/suppliers")
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> retrieveSuppliers() {
        logger.info("Retrieving all suppliers");
        return ResponseEntity.ok(supplierService.retrieveSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable long id) {
        logger.info("Retrieving supplier by ID: {}", id);
        Supplier supplier = supplierService.search(id).orElse(null);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        logger.info("Creating supplier");
        return ResponseEntity.ok(supplierService.storeSupplier(supplier));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable long id, @RequestBody Supplier supplier) {
        logger.info("Updating supplier with ID: {}", id);
        return ResponseEntity.ok(supplierService.updateSupplier(supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable long id) {
        logger.info("Deleting supplier with ID: {}", id);
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
