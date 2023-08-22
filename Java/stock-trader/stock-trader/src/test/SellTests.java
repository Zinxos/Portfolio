package src.test;

import org.junit.jupiter.api.Test;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class SellTests {


    public Account[] accounts= new Account[]{new Personal(BigDecimal.valueOf(3000.00)),
            new TFSA(BigDecimal.valueOf(5000.00))};

    @Test
    public void sellPersonalShares(){
        accounts[0].buyTrade("AAPL",2, BigDecimal.valueOf(25.21));
        accounts[0].sellTrade("AAPL", 1, BigDecimal.valueOf(50.42));
        assertEquals(accounts[0].getStockSharesQuantity("AAPL"), 1);
    }

    @Test
    public void sellTFSAShares(){
        accounts[1].buyTrade("AAPL",2, BigDecimal.valueOf(25.21));
        accounts[1].sellTrade("AAPL", 1, BigDecimal.valueOf(50.42));
        assertEquals(accounts[1].getStockSharesQuantity("AAPL"), 1);
    }

    @Test
    public void overSellPersonalShares(){
        accounts[0].buyTrade("AAPL",1, BigDecimal.valueOf(25.21));
        assertThrows(IllegalStateException.class, () -> accounts[0].sellTrade("AAPL", 2, BigDecimal.valueOf(50.42)));

    }

    @Test
    public void overSellTFSAShares(){
        accounts[1].buyTrade("AAPL",1, BigDecimal.valueOf(25.21));
        assertThrows(IllegalStateException.class, () -> accounts[1].sellTrade("AAPL", 2, BigDecimal.valueOf(50.42)));
    }

    @Test
    public void sellPersonalFundsTest(){
        accounts[0].buyTrade("AAPL",3, BigDecimal.valueOf(0));
        accounts[0].sellTrade("AAPL", 2, BigDecimal.valueOf(50.00));
        assertTrue(accounts[0].getFunds().compareTo(BigDecimal.valueOf(3095.00)) == 0);
    }

    @Test
    public void sellTFSAFundsTest(){
        accounts[1].buyTrade("AAPL",3, BigDecimal.valueOf(0));
        accounts[1].sellTrade("AAPL", 2, BigDecimal.valueOf(50.00));
        assertTrue(accounts[1].getFunds().compareTo(BigDecimal.valueOf(5099.00)) == 0);
    }
}

// TODO: 22.02.2023 sell testy nie działają bo big decimale mają jakiś życiowy problem z zerami, ogarnij o co chodzi
