package com.electra.controller;

import com.electra.model.SupplierModel;
import com.electra.service.SupplierService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electra")
public class SupplierController {

    @Resource(name = "supplierService")
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public List<SupplierModel> getSuppliers(){
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/supplier/{id}")
    public SupplierModel getSupplier(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping("/supplier")
    public SupplierModel saveSupplier(final @RequestBody SupplierModel supplierModel){
        return supplierService.saveSupplier(supplierModel);
    }

    @DeleteMapping("/supplier/{id}")
    public Boolean deleteSupplier(@PathVariable Long id){
        return supplierService.deleteSupplier(id);
    }
}