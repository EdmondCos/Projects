package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Set<Account> getAllAccounts() {
        Set<Account> results = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            results.add(account);
        }
        return results;
    }

    public Account getAccount(String email) {
        return accountRepository.findById(email).get();
    }

    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public boolean exisitsAccount(Account account) {
        Account exisiting;
        try {
            exisiting = accountRepository.findById(account.getEmail()).get();
        } catch (java.util.NoSuchElementException e) {
            return false;
        }
        return exisiting.getPassword().equals(account.getPassword());
    }

    public void delete(String email) {
        accountRepository.deleteById(email);
    }

}
