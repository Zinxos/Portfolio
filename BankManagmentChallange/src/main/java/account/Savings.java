package account;

public class Savings extends Account {
    public static final double  SAVINGS_WITHDRAW_FEE = 5;

    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() + amount);
    }

    @Override
    public boolean withdraw(double amount)
    {
        if(amount + 5 <= super.getBalance())
        {
            super.setBalance(round(super.getBalance() - (amount+SAVINGS_WITHDRAW_FEE)));
            return true;
        }
        return false;
    }

    @Override
    public Account clone() {
        return new Savings(this);
    }

    public Savings(Savings source) {
        super(source);
    }

}
