import java.util.HashMap;
import java.util.Map;

public class Account {
    private int accountID;
    private String userName;
    private double accountBalance;

    public Account(int accountID, String userName, double accountBalance) {
        this.accountID = accountID;
        this.userName = userName;
        this.accountBalance = accountBalance;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getUserName() {
        return userName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            return true;
        }
        return false;
    }

}
