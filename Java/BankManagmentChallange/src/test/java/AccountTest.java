import account.Account;
import account.Chequing;
import account.Loan;
import account.Savings;
import account.tax.Taxable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account[] accounts;

    @BeforeEach
    public void start() {
        accounts = new Account[]{
                new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott", 1524.51),
                new Savings("ce07d7b3-9038-43db-83ae-77fd9c0450c9", "Saul Goodman", 2241.60),
                new Loan("4991bf71-ae8f-4df9-81c1-9c79cff280a5", "Phoebe Buffay", 2537.31)
        };

    }

    @Test
    public void withdrawal() {
        if (accounts[0].withdraw(1440)) ;
        {
            assertEquals(accounts[0].getBalance(), 84.51);
        }
    }

    @Test
    public void overdraw() {
        accounts[0].withdraw(1534.43);
        assertEquals(-15.42, accounts[0].getBalance());
    }

    @Test
    public void overdarftLimit(){
        accounts[0].withdraw(1734.43);
        assertEquals(1524.51, accounts[0].getBalance());
    }

    @Test
    public void savingWithdrawalFee(){
        accounts[1].withdraw(100 );
        assertEquals(2136.60, accounts[1].getBalance());
    }

    @Test
    public void savingOverdarftLimit(){
        accounts[1].withdraw(2734.43);
        assertEquals(2241.60, accounts[1].getBalance());
    }

    @Test
    public void loadWithdrawal(){
        accounts[2].withdraw(2434.31);
        assertEquals(5020.31, accounts[2].getBalance());
    }

    @Test
    public void loanWithdrawalLimit(){
        accounts[2].withdraw(7434.31);
        assertEquals(2537.31, accounts[2].getBalance());
    }

    @Test
    public void chequingDeposit(){
        accounts[0].deposit(1000);
        assertEquals(2524.51,accounts[0].getBalance());
    }

    @Test
    public void loanDeposit(){
        accounts[2].deposit(1000);
        assertEquals(1537.31, accounts[2].getBalance());
    }

    @Test
    public void incomeTax(){
        double income = 4000;
        accounts[0].deposit(income);

        ((Taxable)accounts[0]).tax(income);
        assertEquals(5374.51, accounts[0].getBalance());
    }
    }



