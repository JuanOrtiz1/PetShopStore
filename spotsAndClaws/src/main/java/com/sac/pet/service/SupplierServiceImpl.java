package com.sac.pet.service;


import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sac.pet.model.Supplier;
import com.sac.pet.repository.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	
    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    @Override
    public Supplier createSupplier(Supplier supplier) {
        // Implementa la lógica para guardar el proveedor en la base de datos
        return supplierRepository.save(supplier);
    }
    
    @Override
    public boolean existSupplier(Long supplier) {
    	boolean exist= false;
    	try {
    		 Optional<Supplier> supplierOpt = supplierRepository.findById(supplier);
    	     exist = supplierOpt.isPresent();
    	}catch(Exception e) {
    		System.out.println(e.toString());;
    	}
    	return exist;
    }
    
    @Override
    public String updateSupplier(Long id, Supplier updatedSupplier) {
    	String msg = "";
    	try {
    		if(existSupplier(id)) {
    			Supplier existingSupplier = supplierRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado con ID: " + id));
    			existingSupplier.setDescription(updatedSupplier.getDescription());
    			existingSupplier.setNumberPhone(updatedSupplier.getNumberPhone());
    			existingSupplier.setEmail(updatedSupplier.getEmail());
    			existingSupplier.setStatus(updatedSupplier.getStatus());
    			supplierRepository.save(existingSupplier);
    			msg = "Se ha actualizado correctamente el Proveedor";
    		}else {
    			msg = "No se ha encontrado el Proveedor con el ID" + id;
    		}
    	}catch(Exception E){
			return E.toString();
    	}
		return msg;
    }
    @Override
    public Supplier findSupplierByName(String name) {
        return supplierRepository.findByDescription(name);
    }
    @Override
    public void deleteSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
                          .orElseThrow(() -> new NoSuchElementException("No existe el proveedor con ID: " + id));
        supplierRepository.delete(supplier);
    }
    
    public String changeSupplierStatus(Long id, Supplier supplier) {
        try {
            Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
            if (optionalSupplier.isPresent()) {
                Supplier existingSupplier = optionalSupplier.get();
                existingSupplier.setStatus(supplier.getStatus());
                supplierRepository.save(existingSupplier);
                return "Se ha actualizado el estado del proveedor - ID: " + id;
            } else {
                return "No existe el proveedor que se quiere activar o inactivar - ID: " + id;
            }
        } catch (Exception e) {
            return e.toString();
        }
    }

}