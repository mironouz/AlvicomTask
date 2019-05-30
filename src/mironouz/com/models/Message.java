package mironouz.com.models;

public class Message {
    private AccountNumber accountNumber;
    private String currency;
    private Double amount;
    private Double rate;

    public Message(AccountNumber accountNumber, String currency, double amount) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.amount = amount;
    }

    public Message(AccountNumber accountNumber, String currency, double amount, double rate) {
        this(accountNumber, currency, amount);
        this.rate = rate;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return accountNumber.toString() + "\n" +
                "Currency: " + currency + "\n" +
                "Amount: " + amount + "\n" +
                "Currency rate: " + rate;
    }
}
