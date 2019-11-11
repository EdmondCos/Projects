package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account findByEmail(String email) {
        try {
            return accountRepository.findByEmail(email);
        } catch (java.util.NoSuchElementException e) {
            return new Account();
        }
    }

    public boolean canSaveNewAccount(Account account) {
        try {
            accountRepository.save(account);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean existsAccount(Account account) {
        Account existing = findByEmail(account.getEmail());
        return existing.getPassword().equals(account.getPassword());
    }

    public void delete(String email) {
        accountRepository.deleteById(email);
    }

    public Set<Account> getAllAccounts() {
        Set<Account> results = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            results.add(account);
        }
        return results;
    }


}
