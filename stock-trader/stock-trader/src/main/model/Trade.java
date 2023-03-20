package src.main.model;

import java.math.BigDecimal;

public class Trade {

    enum Type{SELL, BUY}

    public enum Stock{AAPL, FB, GOOG, TSLA}
    Type type;

    Stock stock;

    Integer quantity;

    BigDecimal stockPrice;

    public Trade(Type type, Stock stock, Integer quantity, BigDecimal stockPrice){
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.stockPrice = stockPrice;
    }

    public Trade(Trade sorce){
        this.type = sorce.type;
        this.stock = sorce.stock;
        this.quantity = sorce.quantity;
        this.stockPrice = sorce.stockPrice;
    }
}
