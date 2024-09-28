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
@RequestMapping("/electra/supplier")
public class SupplierController {
    private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        logger.info("Retrieving Suppliers from Get in Controller");
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        logger.info("Retrieving Supplier from Get by ID in Controller");
        Supplier supplier = supplierService.getSupplierById(id);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        logger.info("Creating Supplier from Post in Controller");
        return supplierService.createSupplier(supplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        logger.info("Updating Supplier from Put in Controller");
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        if (updatedSupplier != null) {
            return ResponseEntity.ok(updatedSupplier);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        logger.info("Deleting Supplier from delete in Controller");
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
