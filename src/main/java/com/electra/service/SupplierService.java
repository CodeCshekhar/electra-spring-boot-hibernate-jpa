package com.electra.service;

import com.electra.domain.Supplier;
import com.electra.repository.SupplierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private static final Logger logger = LoggerFactory.getLogger(SupplierService.class);

    @Autowired
    private SupplierRepository supplierRepository;

    @Cacheable("getAllSuppliers")
    public List<Supplier> getAllSuppliers() {
        logger.info("Suppliers Retrieved in Services");
        return supplierRepository.findAll();
    }

    @Cacheable("getSupplierById")
    public Supplier getSupplierById(Long id) {
        logger.info("Supplier detected by ID in Services");
        return supplierRepository.findById(id).orElse(null);
    }

    public Supplier createSupplier(Supplier supplier) {
        logger.info("Supplier Created in Services");
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);
        if (supplier != null) {
            supplier.setName(updatedSupplier.getName());
            supplier.setContactInfo(updatedSupplier.getContactInfo());
            logger.info("Supplier Updated in Services");
            return supplierRepository.save(supplier);
        }
        return null;
    }

    public void deleteSupplier(Long id) {
        logger.info("Payment deleted");
        supplierRepository.deleteById(id);
    }

}
