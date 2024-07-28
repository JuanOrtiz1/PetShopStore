package com.sac.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sac.pet.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
		Product findByDescription(String name);
}
