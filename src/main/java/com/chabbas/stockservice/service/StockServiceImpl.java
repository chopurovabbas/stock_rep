package com.chabbas.stockservice.service;

import com.chabbas.stockservice.dao.StockEntity;
import com.chabbas.stockservice.mapper.StockMapper;
import com.chabbas.stockservice.model.Stock;
import com.chabbas.stockservice.repostiory.StockRepository;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStocks(Integer param) {
        System.out.println(param);
        if(param == 1){
            Stock stock1 = new Stock();
            stock1.setPrice(105);
            stock1.setType("Stock");
            stock1.setName("Apple");
            stock1.setTicker("AAPL");
            stock1.setFigi("1A2");
            stock1.setCurrency("USD");
            saveStockData(stock1);
            updateStockPrice();
/*            Stock stock2 = new Stock();
            stock2.setPrice(100);
            stock2.setType("Stock");
            stock2.setName("AMAZONE");
            stock2.setTicker("AMZN");
            stock2.setFigi("1M2");
            stock2.setCurrency("USD");
            saveStockData(stock2);*/
        }
        List<StockEntity> stockEntities = stockRepository.getStocks();
        List<Stock> stocks = new ArrayList<>();
        for (StockEntity st : stockEntities) {
            stocks.add(StockMapper.toDto(st));
        }
        HttpRequest
        return stocks;
    }

    @Override
    public void saveStockData(Stock stock) {
        stockRepository.saveStockData(stock.getName(),stock.getCurrency(),
                stock.getFigi(),stock.getPrice(),stock.getTicker(),
                stock.getType());
    }

    @Override
    public void updateStockPrice() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                Random random = new Random();
                Random random2 = new Random();
                Integer newPrice = random.nextInt(120 - 100) + 100;
                Integer newPrice2 = random2.nextInt(120 - 100) + 100;
                stockRepository.setApplePrice(newPrice);
                stockRepository.setAmazonPrice(newPrice2);
                System.out.println("updateStockPrice");
            }
        };
        timer.schedule(task, 0L, 10000);
    }


}
