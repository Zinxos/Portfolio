import account.Account;
import account.Chequing;
import account.tax.Taxable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bank {

    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank(){
        accounts = new ArrayList<Account>();
        transactions = new ArrayList<Transaction>();
    }

    public void addAccount(Account account){
        accounts.add(account.clone());
    }

    private void addTransaction(Transaction transaction){
        transactions.add(new Transaction(transaction));
    }

    public Transaction[] getTransactions(String accountID){
       List<Transaction> list = transactions
               .stream()
               .filter(e -> e.getId().equals(accountID))
               .toList();

       return list.toArray(new Transaction[list.size()]);
    }

    public Account getAccount(String transactionId){
        return accounts
                .stream()
                .filter(e->e.getId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }

    private void withdrawTransaction(Transaction transaction){
        if(getAccount(transaction.getId()).withdraw(transaction.getAmount())){
            addTransaction(transaction);
        }
    }
    private void depositTransaction(Transaction transaction){
        getAccount(transaction.getId()).deposit(transaction.getAmount());
        addTransaction(transaction);


    }

    public void executeTransaction(Transaction transaction){
        switch (transaction.getType()){
            case WITHDRAW -> withdrawTransaction(transaction);
            case DEPOSIT -> depositTransaction(transaction);
        }
    }

    public double getIncome(Taxable account){
    Transaction[] transactions = getTransactions(((Chequing)account).getId());
    return Arrays.stream(transactions).
            mapToDouble((transaction)-> {
                switch (transaction.getType()) {
                    case DEPOSIT:
                        return transaction.getAmount();
                    case WITHDRAW:
                        return -transaction.getAmount();
                    default:
                        return 0;
                }
            }).sum();


            }
    public void deductTaxes() {
        for (Account account : accounts) {
            if (Taxable.class.isAssignableFrom(account.getClass())) {
                Taxable taxable = (Taxable)account;
                taxable.tax(getIncome(taxable));
            }
        }
    }
    }


