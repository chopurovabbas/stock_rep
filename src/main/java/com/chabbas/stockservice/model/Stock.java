package com.chabbas.stockservice.model;

import lombok.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Stock {

    String ticker;
    String figi;
    String name;
    String type;
    String currency;
    Integer price;

}

