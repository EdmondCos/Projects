package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Set<Account> getAccounts() {
        Set<Account> result = new HashSet<>();
        for (Account account : accountRepository.findAll()) {
            result.add(account);
        }
        return result;
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
