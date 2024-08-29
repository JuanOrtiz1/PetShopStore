package com.sac.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sac.pet.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
    //List<Stock> findByProductName(String productName);
    List<Stock> findByStock(Long Stock);
}