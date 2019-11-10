package mvc;

import entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import services.AccountService;

import java.util.*;

@Controller
@RequestMapping(value = "")
public class WebController {

    @Autowired
    private AccountService accountService;

    @GetMapping({""})
    public String homePage(Model model) {
        return "login";
    }

    @GetMapping({"/all"})
    public String getAccounts(Model model) {
        model.addAttribute("accounts", getAccountsFromExternalSources());
        return "userHome";
    }

    @GetMapping(value = "/delete")
    public String deleteAccount(Model model, @RequestParam("username") String username) {
        accountService.delete(username);
        model.addAttribute("accounts", getAccountsFromExternalSources());
        return "userHome";
    }

    @GetMapping(value = "/login")
    public String login(Model model, @ModelAttribute Account account) {
        System.out.println("test " + account.getEmail() + " " + account.getPassword());
        boolean x = accountService.exisitsAccount(account);
        if (x) {
            System.out.println("correct data");
            return "userHome";
        } else {
            System.out.println("bad credentials");
            return "login";
        }
    }

    @GetMapping(value = "/register")
    public String newAccount(Model model) {
        return "register";
    }

    @GetMapping(value = "/save-account")
    public String saveAccount(Model model, @ModelAttribute Account account) {
        accountService.createAccount(account);
        model.addAttribute("accounts", getAccountsFromExternalSources());
        return "userHome";
    }


    private Set<Account> getAccountsFromExternalSources() {
        RestTemplate connection = new RestTemplate();
        String url = "http://localhost:8080/twitter/account/all";
        ResponseEntity<Account[]> response = connection.getForEntity(url, Account[].class);

        HashSet<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, Objects.requireNonNull(response.getBody()));

        return accounts;
    }
}
