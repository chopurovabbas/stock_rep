package com.chabbas.stockservice.repostiory;

import com.chabbas.stockservice.dao.StockEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockRepository extends JpaRepository<StockEntity, Long> {


    @Query("select st from StockEntity as st")
    List<StockEntity> getStocks();

    @Transactional
    @Modifying
    @Query("update StockEntity st set st.price = :newPrice where st.id = 1")
    void setApplePrice(@Param("newPrice") Integer newPrice);

    @Transactional
    @Modifying
    @Query("update StockEntity st set st.price = :newPrice where st.id = 2")
    void setAmazonPrice(@Param("newPrice") Integer newPrice);

    @Transactional
    @Modifying
    @Query(value = "insert into stock (name,currency,figi,price,ticker,type) VALUES (:stockName,:stockCurrency,:stockFigi,:stockPrice,:stockTicker,:stockType)", nativeQuery = true)
    void saveStockData(@Param("stockName") String stockName, @Param("stockCurrency") String stockCurrency,
                       @Param("stockFigi") String stockFigi,@Param("stockPrice") Integer stockPrice,
                       @Param("stockTicker") String stockTicker,@Param("stockType") String stockType);
}
