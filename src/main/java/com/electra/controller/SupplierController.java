package com.electra.controller;

import com.electra.domain.Supplier;
import com.electra.service.SupplierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> retrieveSuppliers() {
        logger.info("Retrieving all suppliers");
        return ResponseEntity.ok(supplierService.retrieveSuppliers());
    }

    @PostMapping
    public ResponseEntity<Supplier> storeSupplier(@RequestBody Supplier supplier) {
        logger.info("Storing supplier");
        return ResponseEntity.ok(supplierService.storeSupplier(supplier));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable long id) {
        logger.info("Deleting supplier with id: {}", id);
        return ResponseEntity.ok(supplierService.deleteSupplier(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Supplier>> search(@PathVariable long id) {
        logger.info("Searching for supplier with id: {}", id);
        return ResponseEntity.ok(supplierService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable long id, @RequestBody Supplier supplier) {
        logger.info("Updating supplier with id: {}", id);
        return ResponseEntity.ok(supplierService.updateSupplier(supplier));
    }
}
