package com.electra.controller;

import com.electra.domain.Supplier;
import com.electra.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/electra/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> retrieveSuppliers() {
        return supplierService.retrieveSuppliers();
    }

    @GetMapping("/{supplierId}")
    public String retrieveSupplierForSupplierId(@PathVariable int supplierId) {
        return supplierService.search(supplierId);
    }

    @DeleteMapping("/{supplierId}")
    public String deleteSupplierForSupplierId(@PathVariable int supplierId) {
        return supplierService.deleteSupplier(supplierId);
    }

    @PostMapping
    public String addSupplier(@RequestBody Supplier supplier) {
        return supplierService.storeSupplier(supplier);
    }

    @PutMapping("/{supplierId}")
    public String updateSupplierForSupplierId(@PathVariable int supplierId, @RequestBody Supplier supplier) {
        return supplierService.updateSupplier(supplierId,supplier);
    }
}
