package com.sac.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sac.pet.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	Supplier findByDescription(String name);
}