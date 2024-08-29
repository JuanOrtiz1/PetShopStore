package com.sac.pet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sac.pet.model.Stock;
import com.sac.pet.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
/*
    @GetMapping("/by-name")
    public List<Stock> getStocksByProductName(@RequestParam String productName) {
        return stockService.getStocksByProductName(productName);
    }

    @GetMapping("/by-id")
    public List<Stock> getStocksByProductId(@RequestParam Long productId) {
        return stockService.getStocksByProductId(productId);
    }*/

    @PostMapping
    public Stock addOrUpdateStock(@RequestBody Stock stock) {
        return stockService.addOrUpdateStock(stock);
    }

    @PutMapping("/decrease")
    public void decreaseStock(@RequestParam Long productId, @RequestParam double amountSold) {
        stockService.decreaseStock(productId, amountSold);
    }
}