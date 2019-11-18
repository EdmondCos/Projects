package services;

import dao.AccountRepository;
import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public ModelAndView searchAccounts(ModelAndView model, String username, String keyword) {
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        Set<String> users = new HashSet<>();

        for (Account a : accounts) {
            if (!a.getUsername().equals(username) && a.getUsername().contains(keyword)) {
                users.add(a.getUsername());
            }
        }
        model.addObject("users", users);
        model.setViewName("searchPage");
        return model;
    }
}
