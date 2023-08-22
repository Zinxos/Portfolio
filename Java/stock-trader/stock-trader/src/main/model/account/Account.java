package src.main.model.account;

import src.main.utils.Color;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Account {

public HashMap<String,Integer> portfolio;

public BigDecimal funds;

public Account (BigDecimal funds){
    if(funds.compareTo(BigDecimal.valueOf(0)) == -1)
    {
        throw new IllegalArgumentException("funds cannot be less than 0");
    }
    this.portfolio = new HashMap<String,Integer>();
    this.funds = funds;
}

public Account(Account sorce){
    this.funds = sorce.funds;
}

public abstract void buyTrade(String stockName, Integer quantity, BigDecimal stockPrice);

public abstract void sellTrade(String stockName, Integer quantity, BigDecimal stockPrice);

    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(HashMap<String, Integer> portfolio) {
        this.portfolio = portfolio;
    }

    public BigDecimal getFunds() {
        return funds;
    }

    public void setFunds(BigDecimal funds) {
        if(funds.compareTo(BigDecimal.valueOf(0)) == -1)
        {
            throw new IllegalArgumentException("funds cannot be less than 0");
        }
        this.funds = funds;
    }

    public Integer getStockSharesQuantity(String stockName){
        return this.portfolio.get(stockName);
    }

    public String readPortfolio() {
        String portfolioStr = "";
        for (String stockName : portfolio.keySet())
        {
            portfolioStr =portfolioStr +"  "+  stockName + "\t\t" + portfolio.get(stockName) + "\n";

        }
        return portfolioStr;
    }

    @Override
    public String toString() {
        return "\n  Stock\t\t" + Color.RESET + "Shares" +
                "\n\n" + readPortfolio() + Color.RESET +
                "\n  Funds Left\t" + Color.GREEN + "$" + (this.getFunds()) + Color.RESET;
    }
    }



