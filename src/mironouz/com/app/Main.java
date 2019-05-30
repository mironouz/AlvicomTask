package mironouz.com.app;

import mironouz.com.exceptions.AccountNotExistsException;
import mironouz.com.exceptions.IllegalMessageException;
import mironouz.com.exceptions.NotEnoughMoneyException;
import mironouz.com.logic.ConsoleMessageProcessor;
import mironouz.com.logic.Logger;
import mironouz.com.logic.MessageProcessor;
import mironouz.com.logic.TransactionService;
import mironouz.com.models.AccountInfo;
import mironouz.com.models.AccountNumber;
import mironouz.com.models.AccountStorage;
import mironouz.com.models.InMemoryAccountStorage;
import mironouz.com.models.Message;

public class Main {
    private final static int LOG_LEVEL = 10;
    private final static String WELCOME_MESSAGE = "Please input one by one account number, currency, amount of transfer " +
            "and exchange rate if currency is different from the account";

    public static void main(String[] args) {
        MessageProcessor messageProcessor = new ConsoleMessageProcessor();
        AccountStorage accountStorage = new InMemoryAccountStorage();
        TransactionService transactionService = new TransactionService();
        Logger logger = new Logger(LOG_LEVEL);

        accountStorage.createAccount(new AccountNumber(11111111, 22222222),
                new AccountInfo("HUF", 150_000.0));
        accountStorage.createAccount(new AccountNumber(22222222, 33333333),
                new AccountInfo("USD", 1230.0));
        for(;;) {
            try {
                System.out.println(WELCOME_MESSAGE);
                Message message = messageProcessor.processMessage(accountStorage);
                transactionService.makeTransaction(accountStorage, message);
                accountStorage.getAllAccountInfos()
                        .stream()
                        .forEach((i) -> {
                            logger.log(i.getMessages());
                            logger.log(i.getInvoices());
                        });
            } catch (IllegalMessageException | AccountNotExistsException
                    | NotEnoughMoneyException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
