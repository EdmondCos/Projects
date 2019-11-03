package main.services;

import main.entities.Account;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {
    private static final Set<Account> ACCOUNTS = new HashSet<>();

    public Set<Account> getAccounts() {
        return ACCOUNTS;
    }

    public Account getAccount(String username) {
        for (Account account : ACCOUNTS) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
    }


    public Account createAccount(Account account) {
        ACCOUNTS.add(account);
        return account;
    }

    public void delete(String username) {
        Account account = getAccount(username);
        if (account != null) {
            ACCOUNTS.remove(account);
        }
    }
}
