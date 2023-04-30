package com.chabbas.stockservice.mapper;


import com.chabbas.stockservice.dao.StockEntity;
import com.chabbas.stockservice.model.Currency;
import com.chabbas.stockservice.model.Stock;

public class StockMapper {

    public static Stock toDto(StockEntity entity) {
        Stock dto = new Stock();
        dto.setTicker(entity.getTicker());
        dto.setFigi(entity.getFigi());
        dto.setName(entity.getName());
        dto.setCurrency(entity.getCurrency());
        dto.setType(entity.getType());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public static StockEntity toEntity(Stock stock) {
        StockEntity stockEntity = new StockEntity();
        stockEntity.setTicker(stock.getTicker());
        stockEntity.setFigi(stock.getFigi());
        stockEntity.setName(stock.getName());
        stockEntity.setCurrency(stock.getCurrency());
        stockEntity.setType(stock.getType());
        stockEntity.setPrice(stock.getPrice());
        return stockEntity;
    }


}


