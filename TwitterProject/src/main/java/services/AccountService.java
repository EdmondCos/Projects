package services;

import dao.AccountRepository;
import entities.Account;
import entities.Follower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private AccountRepository accountRepository;

    public ModelAndView searchAccounts(ModelAndView model, String username, String keyword) {
        ArrayList<Account> accounts = (ArrayList<Account>) accountRepository.findAll();
        Set<Follower> followers = new HashSet<>();
        Account user = accountRepository.findByUsername(username);

        for (Account a : accounts) {
            if (!a.getUsername().equals(username) && a.getUsername().contains(keyword)) {
                Follower followed = new Follower();
                followed.setName(a.getUsername());
                if (user.getFollowers().contains(a)) {
                    followed.setSymbol('x');
                } else {
                    followed.setSymbol('+');
                }
                followers.add(followed);
            }
        }
        model.addObject("followers", followers);
        model.addObject("name", username);
        model.setViewName("searchPage");
        return model;
    }

    public ModelAndView updateFollowers(ModelAndView model, String username, Follower follower) {
        Account account = accountRepository.findByUsername(username);
        Set<Account> followers = account.getFollowers();

        Account followed = accountRepository.findByUsername(follower.getName());
        if (follower.getSymbol() == '+') {
            followers.add(followed);
            account.setFollowers(followers);
            accountRepository.save(account);
        } else {
            followers.remove(followed);
            account.setFollowers(followers);
            accountRepository.save(account);
        }
        return messageService.getMessagesOfUser(model, username);
    }

}
