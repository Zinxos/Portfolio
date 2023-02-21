import account.Account;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

        static String ACCOUNTS_FILE = "src/main/data/accounts.txt";
        static String TRANSACTIONS_FILE = "src/main/data/transactions.txt";
        static Bank bank = new Bank();

        public static Account createObject(String[] values) throws Exception {
            try{
                return (Account) Class.forName(values[0])
                        .getConstructor(String.class, String.class, double.class)
                        .newInstance(values[1], values[2], Double.parseDouble(values[3]));
            }catch (Exception e){
                System.out.println(e.getMessage());
                return null;
            }

        }

        public static void loadAccounts(ArrayList<Account> accounts){
            for(Account account:accounts){
                bank.addAccount(account);
            }
        }
        public static ArrayList<Transaction> returnTransactions() throws Exception {
            FileInputStream fis = new FileInputStream(TRANSACTIONS_FILE);
            Scanner scanner = new Scanner(fis);
            ArrayList<Transaction> transactions = new ArrayList<Transaction>();
            String[] values = new String[3];
            while (scanner.hasNextLine()) {
                values = scanner.nextLine().split(",");
                transactions.add(new Transaction(Transaction.Type.valueOf(values[1]), Long.parseLong(values[0]), values[2], Double.parseDouble(values[3])));
            }
            Collections.sort(transactions);
            return transactions;
        }

        public static void runTransactions(ArrayList<Transaction> transactions){
            for (Transaction transaction: transactions) {
                bank.executeTransaction(transaction);
            }
        }

        public static void printTransactions(String id){
            System.out.println("\\t\\t\\t\\t   TRANSACTION HISTORY\\n\\t");
            for (Transaction transaction: bank.getTransactions(id)) {
                System.out.println(transaction);
            }
            System.out.println("\n\t\t\t\t\tAFTER TAX\n");
            System.out.println("\t" + bank.getAccount(id) +"\n\n\n\n");

        }
        public static ArrayList<Account> returnAccounts() throws Exception {
            FileInputStream fis = new FileInputStream(ACCOUNTS_FILE);
            Scanner scanner = new Scanner(fis);
            ArrayList<Account> accounts = new ArrayList<Account>();
            String[] values;
            while (scanner.hasNextLine()){
                values = scanner.nextLine().split(",");
                accounts.add(createObject(values));
            }
            return accounts;
        }
    public static void main(String[] args) throws Exception {
        try {
            ArrayList<Account> accounts = returnAccounts();
            loadAccounts(accounts);

            ArrayList<Transaction> transactions = returnTransactions();
            runTransactions(transactions);
            bank.deductTaxes();
            for (Account account : accounts) {
                System.out.println("\n\t\t\t\t\t ACCOUNT\n\n\t"+account+"\n\n");
                printTransactions(account.getId());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
