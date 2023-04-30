package com.chabbas.stockservice.controller;

import com.chabbas.stockservice.model.Stock;
import com.chabbas.stockservice.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stock")
@CrossOrigin
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/getStocks")
    public List<Stock> getCustomers(@RequestParam Integer param) {
        return stockService.getAllStocks(param);
    }

/*    @GetMapping("/updateStocks")
    public void updateStockPrice() {
        stockService.updateStockPrice();
    }

    @PostMapping("/saveData")
    public void saveStockData(@RequestBody Stock stock) {
        stockService.saveStockData(stock);
    }*/


}
