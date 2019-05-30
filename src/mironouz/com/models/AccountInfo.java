package mironouz.com.models;

import java.util.LinkedList;
import java.util.List;

public class AccountInfo {
    private String currency;
    private Double balance;
    private List<Message> messages;
    private List<Invoice> invoices;

    public AccountInfo(String currency, Double balance) {
        this.currency = currency;
        this.balance = balance;
        messages = new LinkedList<>();
        invoices = new LinkedList<>();
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addMessage(Message message) {
        messages.add(message);
        invoices.add(new Invoice(currency, balance));
    }

    public String getCurrency() {
        return currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return balance + currency;
    }
}
