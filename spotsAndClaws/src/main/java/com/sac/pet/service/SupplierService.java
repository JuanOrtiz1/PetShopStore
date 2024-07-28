package com.sac.pet.service;

import com.sac.pet.model.Supplier;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    String updateSupplier(Long id, Supplier updatedSupplier);
    Supplier findSupplierByName(String name);
    void deleteSupplierById(Long id);
	boolean existSupplier(Long supplier);
	String changeSupplierStatus(Long id, Supplier supplier);

}
