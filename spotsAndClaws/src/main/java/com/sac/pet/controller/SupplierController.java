package com.sac.pet.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sac.pet.model.Supplier;
import com.sac.pet.service.SupplierService;



@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/crearProveedor")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }
    
    @PutMapping("/modificarProveedor/{id}")
    public String updateSupplier(@PathVariable Long id, @RequestBody Supplier updatedSupplier) {
        return supplierService.updateSupplier(id, updatedSupplier);
    }
    
    @PutMapping("/modificarEstadoProveedor/{id}")
    public String changeSupplierStatus(@PathVariable Long id, @RequestBody Supplier supplier) {
        return supplierService.changeSupplierStatus(id, supplier);
    }
    
    @GetMapping("/buscarPorId/{supplier}")
    public boolean getSupplierById(@PathVariable Long supplier) {
        return supplierService.existSupplier(supplier);
    }
    
    @GetMapping("/buscarPorNombre/{description}")
    public Supplier getSupplierByName(@PathVariable String description) {
        return supplierService.findSupplierByName(description);
    }
    
    @DeleteMapping("eliminarProveedor/{id}")
    public ResponseEntity<String> deleteSupplierById(@PathVariable Long id) {
        try {
            supplierService.deleteSupplierById(id);
            return ResponseEntity.ok().body("Se ha eliminado con éxito");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}