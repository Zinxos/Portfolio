package account;

public class Loan extends Account {
    private static final double INTEREST_RATE = 0.02;
    private static final double MAX_DEBT = 10000;
    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }
    public Loan(Loan source) {
        super(source);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(super.getBalance() - amount);
    }

    @Override
    public Account clone() {
        return new Loan(this);
    }
    @Override
    public boolean withdraw(double amount) {
        if(MAX_DEBT >= super.getBalance() + amount + INTEREST_RATE * amount)
    {
        super.setBalance(round(super.getBalance() + amount +INTEREST_RATE * amount));
        return true;
    }
        return false;
    }
}
