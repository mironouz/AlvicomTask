package mironouz.com.models;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountStorage implements AccountStorage {
    private Map<AccountNumber, AccountInfo> accounts = new HashMap<>();

    @Override
    public boolean isAccountExists(AccountNumber accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    @Override
    public void createAccount(AccountNumber accountNumber, AccountInfo accountInfo) {
        accounts.put(accountNumber, accountInfo);
    }

    /*
     * For readability of the code
     */
    @Override
    public void updateAccount(AccountNumber accountNumber, AccountInfo accountInfo) {
        createAccount(accountNumber, accountInfo);
    }

    @Override
    public AccountInfo getAccountInfo(AccountNumber accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Collection<AccountInfo> getAllAccountInfos() {
        return accounts.values();
    }

    @Override
    public String toString() {
        return accounts.toString();
    }
}
