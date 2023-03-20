package src.test;

import org.testng.annotations.Test;
import src.main.model.account.Account;
import src.main.model.account.Personal;
import src.main.model.account.TFSA;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.AssertJUnit.assertEquals;

public class BuyTests {
    
    Account[] accounts= new Account[]{new Personal(BigDecimal.valueOf(3000.00)),
            new TFSA(BigDecimal.valueOf(5000.00))};


    @Test
    public void stockSharesPersonal(){
        accounts[0].buyTrade("AAPL",1, BigDecimal.valueOf(25.21));
        accounts[0].buyTrade("AAPL",2, BigDecimal.valueOf(25.21));
        assertEquals(Integer.valueOf(3), accounts[0].getStockSharesQuantity("AAPL"));
    }


    @Test
    public void fundsPersonal(){
        accounts[0].buyTrade("AAPL",2, BigDecimal.valueOf(25.21));
        assertEquals(accounts[0].funds, BigDecimal.valueOf(3000 - (25.21*2)) );
    }

    @Test
    public void stockSharesTFSA(){
        accounts[1].buyTrade("AAPL",1, BigDecimal.valueOf(25.21));
        accounts[1].buyTrade("AAPL",1, BigDecimal.valueOf(25.21));
        assertEquals(Integer.valueOf(2), accounts[1].getStockSharesQuantity("AAPL"));
    }

    @Test
    public void fundsTFSA(){
        accounts[1].buyTrade("AAPL",2, BigDecimal.valueOf(25.21));
        assertEquals(accounts[1].funds, BigDecimal.valueOf(5000 - ((25.21*1.01)*2)));
    }

    @Test
    public void noFundsBuyPersonal() {
        assertThrows(IllegalStateException.class, () -> accounts[0].buyTrade("AAPL", 1, BigDecimal.valueOf(25000.21)));
    }
}

