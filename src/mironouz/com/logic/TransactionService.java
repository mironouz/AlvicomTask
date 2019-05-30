package mironouz.com.logic;

import mironouz.com.exceptions.NotEnoughMoneyException;
import mironouz.com.models.AccountInfo;
import mironouz.com.models.AccountStorage;
import mironouz.com.models.Message;

import java.util.Optional;

public class TransactionService {
    public void makeTransaction(AccountStorage accountStorage, Message message) throws NotEnoughMoneyException{
        double rate = Optional.ofNullable(message.getRate()).orElse(1.0);
        double amount = message.getAmount() * rate;
        AccountInfo accountInfo = accountStorage.getAccountInfo(message.getAccountNumber());
        if (accountInfo.getBalance() + amount < 0) {
            throw new NotEnoughMoneyException("Not enough money on " + message.getAccountNumber());
        }
        accountInfo.setBalance(accountInfo.getBalance() + amount);
        accountInfo.addMessage(message);
        accountStorage.updateAccount(message.getAccountNumber(), accountInfo);
    }
}
