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
    AccountRepository accountRepository;

    public Set<Account> getAllAccounts() {
        Set<Account> results = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            results.add(account);
        }
        return results;
    }

    public Account getAccount(String username) {
        return accountRepository.findById(username).get();
    }

    public Account createAccount(Account account) {
        accountRepository.save(account);
        return account;
    }

    public void delete(String username) {
        accountRepository.deleteById(username);
    }

}
