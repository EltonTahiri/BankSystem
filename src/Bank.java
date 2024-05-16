import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private String bankName;
    private Map<Integer, Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;
    private JPanel panel1;

    public Bank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        this.bankName = bankName;
        this.transactionFlatFeeAmount = transactionFlatFeeAmount;
        this.transactionPercentFeeValue = transactionPercentFeeValue;
        this.accounts = new HashMap<>();
    }

    public String getBankName(){
        return bankName;
    }

    public double getTotalTransactionFeeAmount(){
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void createAccount(int accountId, String userName, double initialBalance) {
        if (!accounts.containsKey(accountId)) {
            Account account = new Account(accountId, userName, initialBalance);
            accounts.put(accountId, account);
        }
    }

    public boolean performTransaction(int fromAccountId, int toAccountId, double amount, String transactionReason) {
        if (accounts.containsKey(fromAccountId) && accounts.containsKey(toAccountId)) {
            Account fromAccount = accounts.get(fromAccountId);
            Account toAccount = accounts.get(toAccountId);

            double fee = calculateTransactionFee(amount);

            if (fromAccount.withdraw(amount + fee)) {
                toAccount.deposit(amount);
                totalTransactionFeeAmount += fee;
                totalTransferAmount += amount;
                return true;
            }
        }
        return false;
    }
    private double calculateTransactionFee(double amount) {
        return transactionFlatFeeAmount + (transactionPercentFeeValue / 100) * amount;
    }


}
