package com.chabbas.stockservice.service;

import com.chabbas.stockservice.model.Stock;

import java.util.List;

public interface StockService {

    void updateStockPrice();

    List<Stock> getAllStocks(Integer param);

    void saveStockData(Stock stock);
}
