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
    public String loginPage(Model model) {
        accountService.loadAccountDatabase();
        return "login";
    }

    @GetMapping({"home"})
    public String homePage(Model model) {
        return "userHome";
    }


    @GetMapping(value = "/delete")
    public String deleteAccount(Model model, @RequestParam("username") String username) {
        accountService.delete(username);
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
        boolean x = accountService.saveNewAccount(account);
        if (x) {
            return "userHome";
        } else {
            return "register";
        }
    }


    private Set<Account> getAccountsFromExternalSources() {
        RestTemplate connection = new RestTemplate();
        String url = "http://localhost:8080/twitter/account/all";
        ResponseEntity<Account[]> response = connection.getForEntity(url, Account[].class);

        HashSet<Account> accounts = new HashSet<>();
        Collections.addAll(accounts, Objects.requireNonNull(response.getBody()));

        return accounts;
    }


//    TODO:fix hibernate saves only once
//    TODO:lock pages behind login/access
//    TODO:edit and delete account from userpage

}
