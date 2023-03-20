package src.main.model.account;

import java.math.BigDecimal;


public class TFSA extends Account {
    public static final BigDecimal TRADE_FEE = BigDecimal.valueOf(0.01);

    public TFSA(BigDecimal funds) {
        super(funds);
    }

    public TFSA(TFSA sorce){
        super(sorce);
    }

    @Override
    public void buyTrade(String stockName, Integer quantity, BigDecimal stockPrice) {
        if(stockPrice.add(TRADE_FEE.multiply(stockPrice)).compareTo(funds) == 1){
            throw new IllegalStateException("you need more funds to buy those shares");
        }
        setFunds(this.funds.subtract(stockPrice.add((TRADE_FEE.multiply(stockPrice))).multiply(BigDecimal.valueOf(quantity))));
        if (this.portfolio.get(stockName) == null) {
            this.portfolio.put(stockName, quantity);
        }else {
            this.portfolio.replace(stockName, portfolio.get(stockName) + quantity);
        }

    }

    @Override
    public void sellTrade(String stockName, Integer quantity, BigDecimal stockPrice) {
        if(this.portfolio.get(stockName) < quantity)
        {
            throw new IllegalStateException("you can't shares you don't own");
        }
        setFunds(this.funds.add(stockPrice.subtract((stockPrice.multiply(TRADE_FEE))).multiply(BigDecimal.valueOf(quantity))));
        this.portfolio.replace(stockName, portfolio.get(stockName) - quantity);
    }
}
