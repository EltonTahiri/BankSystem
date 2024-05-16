import java.util.Date;

public class Transaction {
    private double amount;
    private int originatingAccountId;
    private int resultingAccountId;
    private String transactionReason;
    private Date transactionDate;
    private boolean flatFee;
    private double transactionFee;

    public Transaction (double amount, int originatingAccountId, int resultingAccountId, String transactionReason,
                        boolean flatFee, double transactionFee)
    {
        this.amount = amount;
        this.originatingAccountId = originatingAccountId;
        this.resultingAccountId = resultingAccountId;
        this.transactionReason = transactionReason;
        this.transactionDate = new Date();
        this.flatFee = flatFee;
        this.transactionFee = transactionFee;
    }

    private double getAmount(){
        return amount;
    }

    public int getOriginatingAccountId(){
        return originatingAccountId;
    }

    public int getResultingAccountId(){
        return resultingAccountId;
    }

    public String getTransactionReason(){
        return transactionReason;
    }

    public Date getTransactionDate(){
        return transactionDate;
    }

    public boolean isFlatFee(){
        return flatFee;
    }

    public double getTransactionFee(){
        return transactionFee;
    }
}