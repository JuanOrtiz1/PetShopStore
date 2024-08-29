package com.sac.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sac.pet.model.Stock;
import com.sac.pet.repository.StockRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
/*
    public List<Stock> getStocksByProductName(String productName) {
        return stockRepository.findByProductName(productName);
    }*/

    public List<Stock> getStocksByStockId(Long stockId) {
        return stockRepository.findByStock(stockId);
    }

    @Transactional
    public Stock addOrUpdateStock(Stock newStock) {
        if (newStock.getStock() != null) {
            Optional<Stock> optionalStock = stockRepository.findById(newStock.getStock());
            if (optionalStock.isPresent()) {
                Stock existingStock = optionalStock.get();
                if ("Granel".equalsIgnoreCase(existingStock.getContainerType()) && "A".equalsIgnoreCase(existingStock.getStatusStock().toString())) {
                    double newContainerWeight = Double.parseDouble(existingStock.getContainerWeight()) + Double.parseDouble(newStock.getContainerWeight());
                    existingStock.setContainerWeight(String.valueOf(newContainerWeight));
                    existingStock.setAmount(existingStock.getAmount() + newStock.getAmount());
                    return stockRepository.save(existingStock);
                }
            }
        }
        return stockRepository.save(newStock);
    }

    @Transactional
    public void decreaseStock(Long stockId, double amountSold) {
        List<Stock> stocks = stockRepository.findByStock(stockId);

        for (Stock stock : stocks) {
            if ("bulto".equalsIgnoreCase(stock.getContainerType()) && "A".equalsIgnoreCase(stock.getStatusStock().toString())) {
                double containerWeight = Double.parseDouble(stock.getContainerWeight());
                if (containerWeight >= amountSold) {
                    containerWeight -= amountSold;
                    stock.setContainerWeight(String.valueOf(containerWeight));
                    if (containerWeight == 0) {
                        stock.setAmount(stock.getAmount() - amountSold);
                    }
                    stockRepository.save(stock);
                    return;
                } else {
                    amountSold -= containerWeight;
                    stock.setContainerWeight("0");
                    stock.setAmount(stock.getAmount() - containerWeight);
                    stockRepository.save(stock);
                }
            } else if (!"bulto".equalsIgnoreCase(stock.getContainerType())) {
                stock.setAmount(stock.getAmount() - amountSold);
                if (stock.getAmount() < 0) {
                    stock.setAmount(0.0);
                }
                stockRepository.save(stock);
                return;
            }
        }

        throw new RuntimeException("Not enough stock available");
    }
}