package mironouz.com.logic;

import mironouz.com.exceptions.AccountNotExistsException;
import mironouz.com.exceptions.IllegalMessageException;
import mironouz.com.models.AccountStorage;
import mironouz.com.models.Message;

public interface MessageProcessor {
    Message processMessage(AccountStorage accountStorage) throws IllegalMessageException, AccountNotExistsException;
}
