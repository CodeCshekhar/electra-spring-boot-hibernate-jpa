package com.electra.service;

import com.electra.model.SupplierModel;

import java.util.List;

public interface SupplierService {
    SupplierModel saveSupplier(SupplierModel supplier);
    boolean deleteSupplier(final Long supplierId);
    List<SupplierModel> getAllSuppliers();
    SupplierModel getSupplierById(final Long supplierId);

}
