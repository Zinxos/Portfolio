package account;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public abstract class Account {
    private String id;
    private String name;
    private BigDecimal balance;

    public Account(String id, String name, BigDecimal balance) {
        if(id.isBlank()||id == null)
        {
            throw new IllegalArgumentException("Id cannot be blank or null");
        }
        if(name.isBlank()||name == null)
        {
            throw new IllegalArgumentException("Name cannot be blank or null");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.isBlank()||id == null)
        {
            throw new IllegalArgumentException("Id cannot be blank or null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isBlank()||name == null)
        {
            throw new IllegalArgumentException("Name cannot be blank or null");
        }
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }



    public abstract void deposit(BigDecimal amount);

    public abstract boolean withdraw(BigDecimal amount);

    public abstract Account clone();

    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + " ACCOUNT " +
                "\t" + this.getId() + "" +
                "\t" + this.getName() + "" +
                "\t$" + this.getBalance() + "";
    }
}
