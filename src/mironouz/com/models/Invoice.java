package mironouz.com.models;

public class Invoice {
    private long id;
    private String currency;
    private Double balance;
    private static long counter = 0;

    public Invoice(String currency, Double balance) {
        this.id = ++counter;
        this.currency = currency;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Invoice #" + id + " Currency: " + currency + " Balance :" + balance;
    }
}
