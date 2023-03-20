package src.main.model.account;

import java.math.BigDecimal;

public class Personal extends Account{

    public static final BigDecimal SELL_FEE = BigDecimal.valueOf(0.05);

    public Personal(BigDecimal funds){
        super(funds);
    }

    public Personal(Personal sorce){
        super(sorce);
    }
    @Override
    public void buyTrade(String stockName, Integer quantity, BigDecimal stockPrice) {
        if(stockPrice.compareTo(funds) == 1){
            throw new IllegalStateException("you need more funds to buy those shares");
        }
        setFunds(this.funds.subtract(stockPrice.multiply(BigDecimal.valueOf(quantity))));
        if (this.portfolio.get(stockName) == null){
            this.portfolio.put(stockName,quantity);
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
        this.portfolio.replace(stockName, portfolio.get(stockName) - quantity);
        setFunds(this.funds.add(stockPrice.subtract((stockPrice.multiply(SELL_FEE))).multiply(BigDecimal.valueOf(quantity))));

    }
}
