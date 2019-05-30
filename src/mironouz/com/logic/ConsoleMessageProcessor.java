package mironouz.com.logic;

import mironouz.com.exceptions.AccountNotExistsException;
import mironouz.com.exceptions.IllegalMessageException;
import mironouz.com.models.AccountNumber;
import mironouz.com.models.AccountStorage;
import mironouz.com.models.Message;

import java.util.Scanner;

public class ConsoleMessageProcessor implements MessageProcessor {
    private final static Scanner sc = new Scanner(System.in);
    private final static int ACCOUNT_PARTS_COUNT = 2;
    private final static int PART_SIZE = 8;
    private final static int CURRENCY_WORD_SIZE = 3;
    private final static String CURRENCY_FORMAT = "[a-zA-Z]+";

    @Override
    public Message processMessage(AccountStorage accountStorage)
            throws IllegalMessageException, AccountNotExistsException {
       String accountNumberStr = sc.nextLine();
       String[] parts = accountNumberStr.split("-");
       if (parts.length != ACCOUNT_PARTS_COUNT ||
               parts[0].length() != PART_SIZE ||
               parts[1].length() != PART_SIZE) {
            throw new IllegalMessageException("Wrong account number pattern: " + accountNumberStr + "\n" +
                    "It should consist of " + ACCOUNT_PARTS_COUNT + " parts each of " + PART_SIZE + " digits");
        }
       int high;
       int low;
       try {
           high = Integer.parseInt(parts[0]);
           low = Integer.parseInt(parts[1]);
       } catch (NumberFormatException e) {
           throw new NumberFormatException("Illegal symbol in the account number");
       }
       AccountNumber accountNumber = new AccountNumber(high, low);
       if (!accountStorage.isAccountExists(accountNumber)) {
           throw new AccountNotExistsException(accountNumber + " does not exist");
       }
       String currency = sc.nextLine();
       if (currency.length() != CURRENCY_WORD_SIZE || !currency.matches(CURRENCY_FORMAT)) {
           throw new IllegalMessageException("Wrong currency: " + currency + "\n" +
                   "It should be size of " + CURRENCY_WORD_SIZE + " and follow " + CURRENCY_FORMAT + " regexp");
       }
       String amountStr = sc.nextLine();
       double amount;
       try {
           amount = Double.parseDouble(amountStr);
       } catch (NumberFormatException e) {
           throw new NumberFormatException("Illegal symbol in the amount");
       }
       if (accountStorage.getAccountInfo(accountNumber).getCurrency().equalsIgnoreCase(currency)) {
           return new Message(accountNumber, currency.toUpperCase(), amount);
       }
       String rateStr = sc.nextLine();
       double rate;
       try {
           rate = Double.parseDouble(rateStr);
       } catch (NumberFormatException e) {
           throw new NumberFormatException("Illegal symbol in the currency rate");
       }
       return new Message(accountNumber, currency.toUpperCase(), amount, rate);
    }
}
