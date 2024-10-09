package com.electra.service;

import com.electra.domain.Supplier;
import com.electra.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);

    @Autowired
    private SupplierRepository repo;

    public List<Supplier> retrieveSuppliers() {
        logger.info("Inside SupplierService.retrieveSuppliers()");
        return repo.findAll();
    }

    public Supplier storeSupplier(Supplier supplier) {
        logger.info("Inside SupplierService.storeSupplier()");
        return repo.save(supplier);
    }

    public String deleteSupplier(long id) {
        logger.info("Inside SupplierService.deleteSupplier()");
        repo.deleteById(id);
        return "Supplier Deleted";
    }

    public Optional<Supplier> search(long id) {
        logger.info("Inside SupplierService.search()");
        return repo.findById(id);
    }

    public Supplier updateSupplier(Supplier supplier) {
        logger.info("Inside SupplierService.updateSupplier()");
        return repo.save(supplier);
    }
}
