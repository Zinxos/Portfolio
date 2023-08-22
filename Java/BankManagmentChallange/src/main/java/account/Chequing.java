package account;

import account.tax.Taxable;

import java.math.BigDecimal;

public class Chequing extends Account implements Taxable {
    private final BigDecimal INCOME_TAXABLE_LIMIT = BigDecimal.valueOf(3000);

    private static final BigDecimal OVERDRAWAL_FEE = BigDecimal.valueOf(5.5);
    private static final double TAX = 0.15;
    public Chequing(String id, String name, BigDecimal balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(BigDecimal amount) {
        super.setBalance(super.getBalance().add(amount));
    }

    @Override
    public boolean withdraw(BigDecimal amount) {
        BigDecimal newBalance = super.getBalance().subtract(amount);
        if (0 == newBalance.compareTo(BigDecimal.valueOf(0)) || 1 == newBalance.compareTo(BigDecimal.valueOf(0))) {
            super.setBalance(newBalance);
            return true;
        }
        if (0 == newBalance.compareTo(BigDecimal.valueOf(-200)) || 1 == newBalance.compareTo(BigDecimal.valueOf(-200))) ) {
            super.setBalance((newBalance.subtract( OVERDRAWAL_FEE)));
            return true;
        }
        System.out.println("overdraw limit is 200$");
        return false;
    }

    public Chequing(Chequing source) {
        super(source);
    }

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void tax(BigDecimal income) {
        double tax = Math.max(0, income.subtract(INCOME_TAXABLE_LIMIT))*TAX;
        super.setBalance(super.round(super.getBalance() - tax));

    }
}


