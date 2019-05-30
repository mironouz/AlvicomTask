package mironouz.com.models;

import java.util.Collection;

public interface AccountStorage {
    boolean isAccountExists(AccountNumber accountNumber);
    void createAccount(AccountNumber account, AccountInfo accountInfo);
    void updateAccount(AccountNumber accountNumber, AccountInfo accountInfo);
    AccountInfo getAccountInfo(AccountNumber accountNumber);
    Collection<AccountInfo> getAllAccountInfos();
}
